package fr.insa.mas.TemperatureSensor.model;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name = "Temperature")
public class Temperature {
	private int indoorTemp;
	private int outdoorTemp;
	
	public Temperature(int indoorTemp, int outdoorTemp) {
		super();
		this.indoorTemp = indoorTemp;
		this.outdoorTemp = outdoorTemp;
	}
	
	public int getIndoorTemp() {
		return indoorTemp;
	}
	
	public void setIndoorTemp(int indoorTemp) {
		this.indoorTemp = indoorTemp;
	}
	
	public int getOutdoorTemp() {
		return outdoorTemp;
	}
	
	public void setOutdoorTemp(int outdoorTemp) {
		this.outdoorTemp = outdoorTemp;
	}
}
