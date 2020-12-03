package com.solvd.university.model;

public class Room extends AbstractEntity {

	private int capacity;
	private int number;
	public Room(long id, int capacity, int number) {
		super(id);
		this.capacity = capacity;
		this.number = number;
	}
	public Room() {
		super();
		this.capacity=0;
		this.number=0;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
}
