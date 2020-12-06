package fr.insa.mas.LuminosityService.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/luminosity")


public class LuminosityResource {

	@GetMapping("/value")
	public int getLuminosity() {
		return (int) Math.ceil(Math.random() * 100);
	}
}
