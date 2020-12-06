package fr.insa.mas.RoomsListService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.insa.mas.RoomsListService.model.IndoorTemperature;
import fr.insa.mas.RoomsListService.model.OutdoorTemperature;
import fr.insa.mas.RoomsListService.model.Room;
import fr.insa.mas.RoomsListService.model.RoomsIDList;
import fr.insa.mas.RoomsListService.model.Window;



@RestController
@RequestMapping("/INSArooms")
public class RoomsListServiceResource {
	
	@GetMapping("/ids")
	public RoomsIDList getIDRooms(){
		
		//Simulate the database using an object RoomsIDList, which contains a list of integers
		RoomsIDList roomsID = new RoomsIDList();
		roomsID.addRoomToList(1);
		roomsID.addRoomToList(2);
		roomsID.addRoomToList(3);
		
		return roomsID;
	}
	
	
	@GetMapping("/all")
	public List<Room> getRooms(){
		
		//Simulate the database using an object RoomsIDList, which contains a list of integers
		RoomsIDList rooms = new RoomsIDList();
		rooms.addRoomToList(1);
		rooms.addRoomToList(2);
		rooms.addRoomToList(3);
		
		//Instanciate RestTemplate for Rest calls
		RestTemplate restTemplate = new RestTemplate();
		int i=0;
		List<Room> listRooms = new ArrayList<Room>();
		
		while (i<rooms.getRoomList().size()){
			//Call the MS to get student's information.
			//The result is deserialised into IndoorTemperature java object
			IndoorTemperature indoorTemp = restTemplate.getForObject("http://localhost:8082/indoorTemp/value/"+i, IndoorTemperature.class);
			
			//Call the MS to get the student's evaluation.
			//The result is deserialised into OutdoorTemperature java object
			OutdoorTemperature outdoorTemp = restTemplate.getForObject("http://localhost:8081/outdoorTemp/value/"+i, OutdoorTemperature.class);
			
			//Call the MS to get the student's evaluation.
			//The result is deserialised into Window java object			
			//TODO : change the return of this request to Window object in WindowService Controller or add another method that return a Window object
			Window window = restTemplate.getForObject("http://localhost:8083/window/opening/"+ i + "?unit=decimal", Window.class); 
			
			//Instanciate a student with his id, his first name, last name, average and store it in the list
			listRooms.add(new Room(i,indoorTemp.getTempVal(),outdoorTemp.getTempVal(),window.getCurrentOpening()));
			i++;
		}
		return listRooms;
	}
}
