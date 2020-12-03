package com.solvd.hospital.model.person;

import java.util.Date;
import java.util.List;

import com.solvd.hospital.enumer.Status;
import com.solvd.hospital.exceptions.NullDiagnosisException;
import com.solvd.hospital.exceptions.NullDiseasesThatHealsException;
import com.solvd.hospital.exceptions.NullPatientException;
import com.solvd.hospital.interfaces.IBook;
import com.solvd.hospital.interfaces.IRegister;
import com.solvd.hospital.interfaces.Reparable;
import com.solvd.hospital.model.Appointment;
import com.solvd.hospital.model.hospital.RoomWithReservation;

public class Doctor extends MedicalWorker implements IBook,IRegister {

	private List<String> diseasesThatHeals;	
	private List<Appointment> apoints;
	private String register;
	private Patient currentPatient;
	
	public Doctor(int id, String name, String phoneNumber, String address, Double salary, List<Appointment> apoints,
			String register, List<String> diseasesThatHeals) {
		super(id, name, phoneNumber, address, salary);
		this.apoints = apoints;
		this.register = register;
		this.diseasesThatHeals = diseasesThatHeals;
		this.currentPatient = null;
	
	}
	
	public Doctor() {
		super();
		this.apoints=null;
		this.register=null;
		this.diseasesThatHeals = null;
		this.currentPatient = null;
	}

	public List<String> getDiseasesThatHeals() {
		return diseasesThatHeals;
	}

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
		currentPatient.setStatus(Status.ACTIVE);
	}

	public void setDiseasesThatHeals(List<String> diseasesThatHeals) throws NullDiseasesThatHealsException {
		if(diseasesThatHeals==null)
			throw new NullDiseasesThatHealsException();
		this.diseasesThatHeals = diseasesThatHeals;
	}
	
	public void addDiseaseThatHeals(String s) {
		this.diseasesThatHeals.add(s);
		
	}
	
	public void removeDiseaseThatHeals(String s) {
		//remove an disease
	}
	
	
	public List<Appointment> getApoints() {
		return apoints;
	}


	public void setApoints(List<Appointment> apoints) {
		this.apoints = apoints;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}
	
	public void addAppointment(Appointment a) {
		//adds an appointment if the date of this is free
	}
	
	public void removeAppointment(String name, Date d, RoomWithReservation r) {
		//remove an appointment using the patient name, the date and the room 
	}

	public boolean fixPatient() throws NullDiagnosisException, NullPatientException {
		
		if(currentPatient==null)
			throw new NullPatientException();
		String s=currentPatient.getDiagnosis();
		if(s==null)
			throw new NullDiagnosisException(); 
		if(this.knowsHowHeal(s)) {
			this.record(new Date(),currentPatient);
			return true;
		}
		else 
			return false;
	}

	public boolean knowsHowHeal(String disease) {
		
		for(String dis: this.getDiseasesThatHeals()) {
			if(dis.equals(disease))
				return true;
		}
		return false;
	}
	
	public void diagnose(Patient p) {
		//doctor will be able to diagnose a patient looking his symptoms
	}
	

	@Override
	public void book(RoomWithReservation r, Doctor d, Patient p, Date date, IBook b) {
		b.book(r, d, p, date, b);
		
	}

	@Override
	public void record(Date date, Reparable m) {
		// TODO Auto-generated method stub
		
	}


}
