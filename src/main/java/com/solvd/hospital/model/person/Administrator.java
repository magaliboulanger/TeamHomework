package com.solvd.hospital.model.person;

public class Administrator extends HospitalWorker{

	public Administrator() {
		super();
	}

	public Administrator(int id, String name, String phoneNumber, String address, Double salary) {
		super(id, name, phoneNumber, address, salary);
	}

	
	public void paySalaries() {
		//The administrator of the Hospital be able to pay to his employees.
	}
}
