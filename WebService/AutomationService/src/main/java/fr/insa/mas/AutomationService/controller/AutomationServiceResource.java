package fr.insa.mas.AutomationService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.AutomationService.model.IndoorTemperature;
import fr.insa.mas.AutomationService.model.OutdoorTemperature;
import fr.insa.mas.AutomationService.model.Shutter;
import fr.insa.mas.AutomationService.model.Window;

@RestController
@RequestMapping("/auto")
public class AutomationServiceResource {
	
	private final String luminosityURI = "http://localhost:4200/luminosity/";
	private final String shutterURI = "http://localhost:4201/shutter/";
	
	private final String outTempURI = "http://localhost:8081/outdoorTemp/";
	private final String inTempURI = "http://localhost:8082/indoorTemp/";
	private final String windowURI = "http://localhost:8083/window/";

	
	@GetMapping(value="/runWindow/{room}")
	public String runWindow(@PathVariable int room){
		RestTemplate restTemplate = new RestTemplate();
		
		String msg="";
		System.out.println("Hello");
		//Récupération de la valeur d'ouverture courante, en%
		double currentOpeningPercent = restTemplate.getForObject(windowURI+ room +"/opening?unit=percent",Double.class);
		msg += "Ouverture actuelle : "+ currentOpeningPercent+" %";
		System.out.println(msg);
		
		//Récupération de l'objet Window
		Window window = restTemplate.getForObject(windowURI+room, Window.class);
		msg += "### Commande actuelle  : "+window.getOrder();
		System.out.println(msg);
		
		//Récupération de la valeur de temperature exterieure
		OutdoorTemperature outdoorTemp = restTemplate.getForObject(outTempURI+"value/" + room, OutdoorTemperature.class);
		double outdoorTempVal = outdoorTemp.getTempVal();
		msg += "--- La temperature exterieure est de "+ outdoorTempVal+"\n";
		System.out.println(msg);
		
		//Récupération de la valeur de temperature exterieure
		IndoorTemperature indoorTemp = restTemplate.getForObject(inTempURI+"value/" + room, IndoorTemperature.class);
		double indoorTempVal = indoorTemp.getTempVal();
		msg += "--- La temperature interieure est de "+ indoorTempVal+"\n";
		System.out.println(msg);
		double order;
		
		if (outdoorTempVal<indoorTempVal && (outdoorTempVal > 18.0 && outdoorTempVal<27)) {
			msg+=" | Il fait beau! -> il faut ouvrir les fenetres";
			order = 100.0;			
		}else{
			msg+=" | Il fait pas beau! -> il faut fermer les fenetres";
			order = 0;
		}
		System.out.println(msg);
		window.setOrder(order); //TODO: add http POST for window using WindowService
		restTemplate.postForObject(windowURI+room+"/order?value="+order, "", String.class);
		
		System.out.println("good");
		
		//Requête de mise à jour du Window
//		restTemplate.put(windowURI, window);
		
		System.out.println("very good");
		
		//Récupération du nouveau statut de l'objet Window
		String newStatus = restTemplate.getForObject(windowURI+room+"/status", String.class);
		msg += " *** Le statut du fenetre est : " + newStatus;
		
		return msg;
	}
	
	
	@GetMapping("/runShutter")
	public String runShutter(){
		RestTemplate restTemplate = new RestTemplate();
		
		String msg="";
		
		//Récupération de la valeur d'ouverture courante, en%
		double currentOpeningPercent = restTemplate.getForObject(shutterURI+"opening?unit=percent",Double.class);
		msg += "Ouverture actuelle : "+ currentOpeningPercent+" %";
		
		//Récupération de l'objet Shutter
		Shutter shutter = restTemplate.getForObject(shutterURI, Shutter.class);
		msg += "### Commande actuelle  : "+shutter.getOrder();
		
		//Récupération de la valeur de luminosité
		int luminosity = restTemplate.getForObject(luminosityURI+"value", Integer.class);
		msg += "--- La luminosité est de "+ luminosity+"\n";
		
		if(luminosity>50){
			msg+=" | Forte luminosité -> il faut fermer les volets";
			double order = (100 - luminosity)/100.0;
			shutter.setOrder(order);
		}else{
			msg += " | Faible luminosité -> il faut ouvrir les volets";
			double order = 0.005 + (100 - luminosity)/100.0;
			shutter.setOrder(order);
		}
		//Requête de mise à jour du Shutter
		restTemplate.put(shutterURI, shutter);
		
		//Récupération du nouveau statut de l'objet Shutter
		String newStatus = restTemplate.getForObject(shutterURI+"status", String.class);
		msg += " *** Le statut du volet est : " + newStatus;
		
		return msg;
	}
}
