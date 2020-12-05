package fr.insa.mas.AutomationService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.AutomationService.model.Shutter;

@RestController
@RequestMapping("/auto")
public class AutomationServiceResource {
	
	private final String luminosityURI = "http://licalhost:4200/luminosity/";
	private final String shutterURI = "http://localhost:4201/shutter/";
	
	@GetMapping("/run")
	public String run(){
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
