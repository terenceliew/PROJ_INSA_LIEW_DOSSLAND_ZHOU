package fr.insa.mas.IndoorTemperatureService.model;

public class IndoorTemperature {
	
	private int room;
	private double tempVal;
	
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
