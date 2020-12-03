package com.solvd.university.model;

public class Teacher extends Person {

	public Teacher(long id, String name, String phone, Address address, String email) {
		super(id, name, phone, address, email);
	}
	public Teacher(long id, String name, String phone, String email) {
		super(id, name, phone,email);
	}
	public Teacher() {
		super();
	}
	


	
}
