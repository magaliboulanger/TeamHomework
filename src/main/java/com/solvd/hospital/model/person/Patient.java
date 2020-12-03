package com.solvd.hospital.model.person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.solvd.hospital.enumer.Level;
import com.solvd.hospital.enumer.Status;
import com.solvd.hospital.exceptions.NullSymptomsException;
import com.solvd.hospital.interfaces.ISearchRecord;
import com.solvd.hospital.interfaces.Reparable;
import com.solvd.hospital.model.Record;

public class Patient extends Person implements ISearchRecord, Reparable{
	private List<String> symptoms;
	private String diagnosis;
	private ArrayList<Record> records;
	private Level levelOfEmergency;
	private Status status;
	
	//constructors
	
	public Patient(int id, String name, String phoneNumber, String address, List<String> symptoms, Level l, Status s) throws NullSymptomsException {
		super(id, name, phoneNumber, address);
		this.setSymptoms(symptoms);
		this.diagnosis = null;
		this.levelOfEmergency=l;
		this.status = s;
	}
	
	public Patient() {
		super();
		this.diagnosis=null;
		this.symptoms=null;
		this.levelOfEmergency=null;
		this.status = null;
	}

	//getters and setters
	public void setSymptoms(List<String> symptoms) throws NullSymptomsException {
		if (symptoms==null)
			throw new NullSymptomsException();
		this.symptoms = symptoms;
	}

	 
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ArrayList<Record> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

	public Level getLevelOfEmergency() {
		return levelOfEmergency;
	}

	public void setLevelOfEmergency(Level levelOfEmergency) {
		this.levelOfEmergency = levelOfEmergency;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public void searchRecord() {
		//TODO
	}

	@Override
	public void repare() {
		// TODO Auto-generated method stub
		
	}

	public void addRecord(Record rec) {
		records.add(rec);
	}

	
}
