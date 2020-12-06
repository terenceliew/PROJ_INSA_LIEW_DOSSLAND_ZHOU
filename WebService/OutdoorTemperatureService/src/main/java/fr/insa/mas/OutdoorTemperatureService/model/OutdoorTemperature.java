package fr.insa.mas.OutdoorTemperatureService.model;

public class OutdoorTemperature {
	private int room;
	private double tempVal;
	
	public OutdoorTemperature(int room, double tempVal) {
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
