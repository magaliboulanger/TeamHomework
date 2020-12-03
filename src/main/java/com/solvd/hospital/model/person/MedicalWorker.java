package com.solvd.hospital.model.person;

import com.solvd.hospital.exceptions.NullDiagnosisException;
import com.solvd.hospital.exceptions.NullPatientException;

public abstract class MedicalWorker extends HospitalWorker {

	
	
	public MedicalWorker(int id, String name, String phoneNumber, String address, Double salary) {
		super(id, name, phoneNumber, address, salary);
	}

	public MedicalWorker() {
		super();
		
	}
	
	
		
	public abstract boolean fixPatient() throws NullDiagnosisException, NullPatientException;
	
}
