package com.solvd.university.model;

public class Student extends Person {

	private int universityIdentifier;
	
	public Student(long id, String name, String phone, Address address, int ui, String email) {
		super(id, name, phone, address, email);
		this.universityIdentifier=ui;
	}

	public Student(long id, String name, String phone, int ui, String email) {
		super(id, name, phone, email);
		this.universityIdentifier=ui;
	}

	public Student(int ui) {
		super();
		this.universityIdentifier=ui;
	}
	public Student() {
		super();
		this.universityIdentifier=0;
	}

	public int getUniversityIdentifier() {
		return universityIdentifier;
	}

	public void setUniversityIdentifier(int universityIdentifier) {
		this.universityIdentifier = universityIdentifier;
	}

	
	
}
