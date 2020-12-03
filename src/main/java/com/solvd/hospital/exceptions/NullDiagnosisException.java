package com.solvd.hospital.exceptions;

public class NullDiagnosisException extends Exception{

	public NullDiagnosisException() {
		super("The patient hasn't a diagnosis yet.");
	}
}
