package fr.insa.mas.WindowService.controller;

import org.eclipse.om2m.commons.resource.ContentInstance;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import fr.insa.mas.WindowService.model.Mapper;
import fr.insa.mas.WindowService.model.Window;

@RestController
@RequestMapping("/window")
public class WindowResource {
	
	Window window = new Window(1, 5.9, 6.7, true);

	@GetMapping(value ="/{room}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Window getWindow(@PathVariable("room") int room) {
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/Window_" + room + "/DATA/la";
		
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
		
		double windowDecimal = Double.parseDouble(cin.getContent());
		
		System.out.println (windowDecimal);

//		Window window = new Window(room, windowDecimal, windowDecimal, false); //to be changed with exact data from OM2M
		window.setRoom(room);
		window.setCurrentOpening(windowDecimal);
		return window;
	}
		
	@GetMapping("/{room}/status")
	public String getStatus(@PathVariable("room") int room){
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
//		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/Window_" + room + "/DATA/la";
				
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
				
		double windowDecimal = Double.parseDouble(cin.getContent());
				
		System.out.println (windowDecimal);

//		Window window = new Window(room, windowDecimal, windowDecimal, false); //to be changed with exact data from OM2M
		window.setRoom(room);
		window.setCurrentOpening(windowDecimal);
		
		
		if (window.isMoving()) return "moving from " + window.getCurrentOpening() + " to " + window.getOrder();
		if(window.getCurrentOpening() > 0) return "open";
		return "closed";
	}
		
	@GetMapping("/{room}/opening")
	public double getOpening(@PathVariable("room") int room, @RequestParam(name = "unit", required=false) String unit){
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
//		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/Window_" + room + "/DATA/la";
				
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
				
		double windowDecimal = Double.parseDouble(cin.getContent());
				
		System.out.println (windowDecimal);

//		Window window = new Window(room, windowDecimal, windowDecimal, false); //to be changed with exact data from OM2M
		window.setRoom(room);
		window.setCurrentOpening(windowDecimal);
		
		
		if (unit == null || unit.equals("decimal")) return window.getCurrentOpening();
		if (unit.equals("percent")) return window.getCurrentOpening() * 100;
		return -1;
	}
		
	@PostMapping("/{room}/order")
	public void setOrder(@PathVariable("room") int room, @RequestParam double value) {
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		
		
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/Window_" + room + "/DATA";
				
		//Instanciate RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
						
		//create headers
		HttpHeaders headers = new HttpHeaders();
						
		// add basic authentication header
		headers.set("X-M2M-Origin", "admin:admin");
		headers.set("Accept", "application/json");
						
		headers.set("Content-Type","application/json;ty=4");
		
		String json = "{\"m2m:cin\":{\"cnf\":\"application/xml\",\"con\":\""+value+"\"}}";

		// build the request
		HttpEntity<String> request = new HttpEntity<String>(json,headers);
						
		// make an HTTP POST request with headers
		ResponseEntity<String> response = restTemplate.exchange(
				      url,
				      HttpMethod.POST,
				      request,
				      String.class
		);
		
		String resp = (String)response.getBody();
		
		System.out.println(resp);
		
		
//		Window window = new Window(room, 0.5, value, false); //to be changed with exact data from OM2M
		
		window.setRoom(room);
		window.setOrder(value);
		
		
	}
		
	@PutMapping("/{room}")
	public void updateWindow(@PathVariable("room") int room, @RequestBody Window window) {
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
//		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		
		// request url
		String url = "http://localhost:8080/~/mn-cse/mn-name/Window_" + room + "/DATA/la";
						
		//Instanciate RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
								
		//create headers
		HttpHeaders headers = new HttpHeaders();
								
		// add basic authentication header
		headers.set("X-M2M-Origin", "admin:admin");
		headers.set("Accept", "application/json");
								
		headers.set("Content-Type","application/json;ty=4");
				
		String json = "{\"m2m:cin\":{\"cnf\":\"application/xml\",\"con\":\""+window.getOrder()+"\"}}";

		// build the request
		HttpEntity<String> request = new HttpEntity<String>(json,headers);
								
		// make an HTTP PUT request with headers
		ResponseEntity<String> response = restTemplate.exchange(
				      url,
				      HttpMethod.PUT,
				      request,
				      String.class
		);
				
		String resp = (String)response.getBody();
				
		System.out.println(resp);
		
		
//		window.setOrder(window_la.getOrder());
		this.window.setOrder(window.getOrder());
	}	
	
}
