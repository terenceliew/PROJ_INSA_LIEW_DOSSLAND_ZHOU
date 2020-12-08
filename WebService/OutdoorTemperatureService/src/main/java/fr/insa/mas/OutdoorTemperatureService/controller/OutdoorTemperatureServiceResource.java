package fr.insa.mas.OutdoorTemperatureService.controller;

import java.util.Collections;

import org.eclipse.om2m.commons.resource.ContentInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.OutdoorTemperatureService.model.OutdoorTemperature;
import fr.insa.mas.OutdoorTemperatureService.model.Mapper;
import fr.insa.mas.OutdoorTemperatureService.model.OutdoorTemperature;

@RestController
@RequestMapping("/outdoorTemp")
public class OutdoorTemperatureServiceResource {
	
	@GetMapping(value="/value/{room}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OutdoorTemperature getOutdoorTemp(@PathVariable int room){ //TODO : Change return to OutdoorTemperature 
		
		
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/OutdoorTemp_" + room + "/DATA/la";
		
		//Instanciate RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		
		//create headers
		HttpHeaders headers = new HttpHeaders();
		
		// add basic authentication header
		headers.set("X-M2M-Origin", "admin:admin");
		headers.set("Accept", "application/xml");
				
//		headers.setContentType(MediaType.APPLICATION_JSON);
				
		// build the request
		HttpEntity<String> request = new HttpEntity<String>("parameters",headers);
		
		// make an HTTP GET request with headers
		ResponseEntity<String> response = restTemplate.exchange(
		        url,
		        HttpMethod.GET,
		        request,
		        String.class
		);
		
		String resp = (String) response.getBody();
		System.out.println(resp);

		Mapper mapper = new Mapper();

		ContentInstance cin = (ContentInstance) mapper.unmarshal(resp);
		
		System.out.println ("************");
		
		double outdoorTempVal = Double.parseDouble(cin.getContent());
		
		System.out.println (outdoorTempVal);
		
		OutdoorTemperature outdoorTemp = new OutdoorTemperature(room, outdoorTempVal);

		return outdoorTemp;
		
	}
}
