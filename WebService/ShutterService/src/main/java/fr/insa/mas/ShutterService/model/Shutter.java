package fr.insa.mas.ShutterService.model;

public class Shutter {
	
	
	private double currentState;
	private double order;
	private boolean isMoving;
	
	public Shutter() {}

	public Shutter(double currentState, double order, boolean isMoving) {
		super();
		this.currentState = currentState;
		this.order = order;
		updateIsMoving();
	}
	
	public double getCurrentState() {
		return currentState;
	}

	public void setCurrentState(double currentState) {
		this.currentState = currentState;
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
		this.isMoving = !(this.order == this.currentState);
	}
	
	
}
