package com.solvd.hospital.model.hospital;

import java.util.List;

import com.solvd.hospital.model.person.HospitalWorker;

public class Area<T extends HospitalWorker> {

	private int id;
	private String name;
	private T director;
	private List<Machine> machines; 
	private List<Room> rooms;
	
	public Area(int id, String name, T director, List<Machine> machines, List<Room> rooms) {
		this.id = id;
		this.name = name;
		this.director = director;
		this.machines = machines;
		this.rooms = rooms;
	}
	
	public Area() {
		this.id = -1;
		this.name = null;
		this.director = null;
		this.machines = null;
		this.rooms = null; 
	}

	public int getId() { return id;}

	public void setId(int id) { this.id = id;	}

	public String getName() { return name;}

	public void setName(String name) { this.name = name; }

	public T getDirector() { return director; }

	public void setDirector(T director) { this.director = director; }

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	
	
}
