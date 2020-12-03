package com.solvd.hospital.model.person;

public class Nurse extends MedicalWorker {

	private String skill;
	private Patient currentPatient;
	
	public Nurse(int id, String name, String phoneNumber, String address, Double salary, String skill) {
		super(id, name, phoneNumber, address, salary);
		this.skill = skill;
		this.currentPatient = null;
	}

	public Nurse () {
		super();
		this.skill = null;
		this.currentPatient = null;
	}
	
	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	@Override
	public boolean fixPatient() {
		if (currentPatient.getDiagnosis().equals(this.skill))
			return true;
		else return false;
	}

	
	
}
