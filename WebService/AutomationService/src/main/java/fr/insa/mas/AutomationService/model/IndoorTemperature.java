package fr.insa.mas.AutomationService.model;

public class IndoorTemperature {
	
	private int room;
	private double tempVal;
	
	
	
	public IndoorTemperature() {
		super();
	}

	public IndoorTemperature(int room, double tempVal) {
		super();
		this.room = room;
		this.tempVal = tempVal;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public double getTempVal() {
		return tempVal;
	}

	public void setTempVal(double tempVal) {
		this.tempVal = tempVal;
	}
	
	
}
