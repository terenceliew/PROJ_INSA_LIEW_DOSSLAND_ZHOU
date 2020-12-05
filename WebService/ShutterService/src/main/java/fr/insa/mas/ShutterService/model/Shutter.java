package fr.insa.mas.ShutterService.model;

public class Shutter {
	
	
	private double currentOpening;
	private double order;
	private boolean isMoving;
	
	public Shutter() {}

	public Shutter(double currentOpening, double order, boolean isMoving) {
		super();
		this.currentOpening = currentOpening;
		this.order = order;
		updateIsMoving();
	}
	
	public double getCurrentOpening() {
		return currentOpening;
	}

	public void setCurrentOpening(double currentOpening) {
		this.currentOpening = currentOpening;
	}

	public double getOrder() {
		return order;
	}

	public void setOrder(double order) {
		this.order = order;
	}

	public boolean isMoving() {
		return isMoving;
	}
	
	public void updateIsMoving() {
		this.isMoving = !(this.order == this.currentOpening);
	}
	
	
}
