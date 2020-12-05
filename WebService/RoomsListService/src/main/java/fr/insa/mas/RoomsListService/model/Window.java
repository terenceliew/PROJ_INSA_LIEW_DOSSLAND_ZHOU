package fr.insa.mas.RoomsListService.model;

public class Window {
	private int room;
	private double currentOpening;
	private double order;
	private boolean isMoving;
	
	
	public Window(int room, double currentOpening, double order, boolean isMoving) {
		super();
		this.room = room;
		this.currentOpening = currentOpening;
		this.order = order;
		this.isMoving = isMoving;
	}
	
	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
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

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}
}
