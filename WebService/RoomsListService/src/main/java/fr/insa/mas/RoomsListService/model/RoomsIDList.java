package fr.insa.mas.RoomsListService.model;

import java.util.ArrayList;
import java.util.List;

public class RoomsIDList {
	List <Integer> roomList;

	public RoomsIDList() {
		this.roomList = new ArrayList<Integer>();
	}

	public List<Integer> getRoomList() {
		return roomList;
	}

	public void addRoomToList(Integer roomId){
		this.roomList.add(roomId);
	}
	
	
	
}
