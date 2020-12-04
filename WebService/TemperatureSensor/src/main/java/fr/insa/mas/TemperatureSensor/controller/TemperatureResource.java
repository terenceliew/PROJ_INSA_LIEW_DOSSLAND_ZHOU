package fr.insa.mas.TemperatureSensor.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.TemperatureSensor.model.Temperature;



@RestController
public class TemperatureResource {
	
//	private class TemperatureVal{
//		@JsonProperty("Temperature Value")
//		
//		
//	}
	
	
	@GetMapping("/indoorTemp")
	public int indoorTempVal(){
		//OM2M
		return 27;
	}
	
	@GetMapping("/outdoorTemp")
	public int outdoorTempVal(){
		//OM2M
		return 15;
	}
	
	@GetMapping(value="/trial", produces = MediaType.APPLICATION_JSON_VALUE)
	public String trialtemp(){
		
		
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/OutdoorTemp_1/DATA/la";
		
		//Instanciate RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		
		//create headers
		HttpHeaders headers = new HttpHeaders();
		
		// add basic authentication header
		headers.set("X-M2M-Origin", "admin:admin");

		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		
		// build the request
		HttpEntity request = new HttpEntity(headers);
		
		// make an HTTP GET request with headers
		ResponseEntity<String> response = restTemplate.exchange(
		        url,
		        HttpMethod.GET,
		        request,
		        String.class
		);
		
		String resp = response.getBody();
		return resp;
//		int outdoorTemp = temp.getOutdoorTemp();
		
//		Temperature temp = restTemplate.getForObject("http://localhost:8080/~/mn-cse/mn-name/OutdoorTemp_1/DATA/la", Temperature.class);
//		int outdoorTemp = temp.getOutdoorTemp();
		
//		return outdoorTemp;
		
	}
	
	
	
}
