package com.solvd.hospital.exceptions;

public class NullDateException extends Exception{

	public NullDateException() {
		super("Appointment should have a date.");
	}

	
}
