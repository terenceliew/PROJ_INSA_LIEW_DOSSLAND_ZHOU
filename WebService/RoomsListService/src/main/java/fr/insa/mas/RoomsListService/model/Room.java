package fr.insa.mas.RoomsListService.model;

public class Room {
	
	private int roomID;
	private double indoorTemp;
	private double outdoorTemp;
	private double windowOpening;
	
	public Room(int roomID, double indoorTemp, double outdoorTemp, double windowOpening) {
		super();
		this.roomID = roomID;
		this.indoorTemp = indoorTemp;
		this.outdoorTemp = outdoorTemp;
		this.windowOpening = windowOpening;
	}
	
	public int getRoomID() {
		return roomID;
	}
	
	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}
	
	public double getIndoorTemp() {
		return indoorTemp;
	}
	
	public void setIndoorTemp(double indoorTemp) {
		this.indoorTemp = indoorTemp;
	}
	
	public double getOutdoorTemp() {
		return outdoorTemp;
	}
	
	public void setOutdoorTemp(double outdoorTemp) {
		this.outdoorTemp = outdoorTemp;
	}
	
	public double getWindowOpening() {
		return windowOpening;
	}
	
	public void setWindowOpening(double windowOpening) {
		this.windowOpening = windowOpening;
	}
	
	
}
