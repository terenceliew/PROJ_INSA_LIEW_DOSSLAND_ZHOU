package fr.insa.mas.AutomationService.controller;

import org.springframework.http.MediaType;
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
	
	private final String outTempURI = "http://localhost:8081/outdoorTemp/";
	private final String inTempURI = "http://localhost:8082/indoorTemp/";
	private final String windowURI = "http://localhost:8083/window/";

	
	@GetMapping(value="/runWindow/{room}", produces = MediaType.TEXT_HTML_VALUE)
	public String runWindow(@PathVariable int room){
		RestTemplate restTemplate = new RestTemplate();
		
		String msg="";
		//Récupération de la valeur d'ouverture courante, en%
		double currentOpeningPercent = restTemplate.getForObject(windowURI+ room +"/opening?unit=percent",Double.class);
		msg += "<p>Current Opening ([0%,100%] 0 % = closed, 100 % = open): "+ currentOpeningPercent+" %</p>\n";
		System.out.println(msg);
		
		//Récupération de l'objet Window
		Window window = restTemplate.getForObject(windowURI+room, Window.class);
		msg += "<p>Current Order ([0,1] 0 = closed, 1 = open) : "+window.getOrder()+"</p>\n";
		System.out.println(msg);
		
		//Récupération de la valeur de temperature exterieure
		OutdoorTemperature outdoorTemp = restTemplate.getForObject(outTempURI+"value/" + room, OutdoorTemperature.class);
		double outdoorTempVal = outdoorTemp.getTempVal();
		msg += "<p>Outdoor Temperature : "+ outdoorTempVal+" °C</p>\n";
		System.out.println(msg);
		
		//Récupération de la valeur de temperature interieure
		IndoorTemperature indoorTemp = restTemplate.getForObject(inTempURI+"value/" + room, IndoorTemperature.class);
		double indoorTempVal = indoorTemp.getTempVal();
		msg += "<p>Indoor Temperature : "+ indoorTempVal+" °C</p>\n";
		System.out.println(msg);
		double order;
		
		if (outdoorTempVal<indoorTempVal && (outdoorTempVal > 18.0 && outdoorTempVal<27)) {
			msg+="<p>Nice weather outside! -> Open the window!</p>\n";
			order = 1.0; //order in decimal			
		}else{
			msg+="<p>Terrible weather outside! -> Close the window!</p>\n";
			order = 0;  //order in decimal
		}
		msg+="<p>New Order ([0,1] 0 = closed, 1 = open) : " + order + "</p>\n";
		System.out.println(msg);
//		window.setOrder(order); //TODO: add http POST for window using WindowService
		restTemplate.postForObject(windowURI+room+"/order?value="+order, "", String.class);
		
		//Requête de mise à jour du Window
		restTemplate.put(windowURI+room, null);
		
		//Récupération du nouveau statut de l'objet Window
		String newStatus = restTemplate.getForObject(windowURI+room+"/status", String.class);
		msg += "<p>New Status of window : " + newStatus + "</p>\n";
		
		return "<html>\n" + "<header><title>Automation Service Result</title></header>\n" + "<h1>Automation Service of Room " + room + "</h1>\n" + "<body>\n" + msg + "</body>\n" + "</html>";
	}
	
}
