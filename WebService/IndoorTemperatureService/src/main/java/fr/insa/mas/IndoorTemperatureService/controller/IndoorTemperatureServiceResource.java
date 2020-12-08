package fr.insa.mas.IndoorTemperatureService.controller;

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


import fr.insa.mas.IndoorTemperatureService.model.IndoorTemperature;
import fr.insa.mas.IndoorTemperatureService.model.Mapper;

@RestController
@RequestMapping("/indoorTemp")
public class IndoorTemperatureServiceResource {
	
	@GetMapping(value="/value/{room}", produces = MediaType.APPLICATION_JSON_VALUE)
	public IndoorTemperature getIndoorTemp(@PathVariable int room){ //TODO : Change return to IndoorTemperature 
		
		
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/IndoorTemp_" + room + "/DATA/la";
		
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
		
		String resp = (String)response.getBody();
		
		System.out.println(resp);

		Mapper mapper = new Mapper();

		ContentInstance cin = (ContentInstance) mapper.unmarshal(resp);
		
		System.out.println ("************");
		
		double indoorTempVal = Double.parseDouble(cin.getContent());
		
		System.out.println (indoorTempVal);
		
		IndoorTemperature indoorTemp = new IndoorTemperature(room, indoorTempVal);

		return indoorTemp;
//		int outdoorTemp = temp.getOutdoorTemp();
		
//		Temperature temp = restTemplate.getForObject("http://localhost:8080/~/mn-cse/mn-name/OutdoorTemp_1/DATA/la", Temperature.class);
//		int outdoorTemp = temp.getOutdoorTemp();
		
//		return outdoorTemp;
		
	}
}
