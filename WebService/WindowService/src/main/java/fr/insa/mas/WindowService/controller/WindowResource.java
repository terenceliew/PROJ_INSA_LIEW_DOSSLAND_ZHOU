package fr.insa.mas.WindowService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.insa.mas.WindowService.model.Window;

@RestController
@RequestMapping("/window")
public class WindowResource {
	

	@GetMapping("/{room}")
	public Window getShutter(@PathVariable("room") int room) {
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		return window;
	}
		
	@GetMapping("/status/{room}")
	public String getStatus(@PathVariable("room") int room){
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		
		if (window.isMoving()) return "moving from " + window.getCurrentOpening() + " to " + window.getOrder();
		if(window.getCurrentOpening() > 0) return "open";
		return "closed";
	}
		
	@GetMapping("/opening/{room}")
	public double getOpening(@PathVariable("room") int room, @RequestParam(name = "unit", required=false) String unit){
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		
		if (unit == null || unit.equals("decimal")) return window.getCurrentOpening();
		if (unit.equals("percent")) return window.getCurrentOpening() * 100;
		return -1;
	}
		
	@PostMapping("/order/{room}")
	public void setOrder(@PathVariable("room") int room, @RequestParam double value) {
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		
		window.setOrder(value);
	}
		
	@PutMapping("/{room}")
	public void updateWindow(@PathVariable("room") int room, @RequestBody Window window_la) {
		//retrieve window latest data instance from OM2M and create a new instance of window object with that latest data
		Window window = new Window(room, 0.5, 1.0, false); //to be changed with exact data from OM2M
		
		window.setOrder(window_la.getOrder());
	}	
	
}
