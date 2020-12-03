package com.solvd.hospital.exceptions;

public class NullPatientException extends Exception{

	public NullPatientException() {
		super("Doctor hasn't patient to fix yet.");
	}

}
