package com.solvd.hospital.model.hospital;

import java.util.List;

public class Room {

	private String name;
	private int id;
	private List<Machine> machines;
	
	public Room(int id, String name, List<Machine> machines) {
		this.name = name;
		this.id = id;
		this.machines= machines;
	}

	public Room() {
		this.id = -1;
		this.name = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Machine> getMachines() {
		return machines;
	}

	public void setMachines(List<Machine> machines) {
		this.machines = machines;
	}

	
}
