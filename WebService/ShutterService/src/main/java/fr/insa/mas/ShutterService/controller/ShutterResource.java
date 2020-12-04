package fr.insa.mas.ShutterService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.ShutterService.model.Shutter;

@RestController
@RequestMapping("/shutter")
public class ShutterResource {
	
	private Shutter shutter = new Shutter(0.5, 1.0, true);
	
	@GetMapping("/")
	public Shutter getShutter() {
		return shutter;
	}
	
//	@GetMapping("/status"){
//		
//	}
	
	
	
	
}
