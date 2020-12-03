package com.solvd.hospital.exceptions;

public class NullDirectorException extends Exception {
	
	public NullDirectorException() {
		super("Responsable should not be null in a private room.");
	}
}
