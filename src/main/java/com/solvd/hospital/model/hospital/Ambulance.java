package com.solvd.hospital.model.hospital;

import java.sql.Date;

import com.solvd.hospital.interfaces.Operable;

public class Ambulance implements Operable {
	private String id;
	private Date birth;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Ambulance(String id, Date birth) {
		this.id = id;
		this.birth = birth;
	}
	
	public Ambulance () {
		this.birth=null;
		this.id=null;
	}
	
	public void operate() {
		//todo
	}
	
	public void drive() {
		
	}
}
