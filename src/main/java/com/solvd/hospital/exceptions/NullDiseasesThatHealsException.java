package com.solvd.hospital.exceptions;

public class NullDiseasesThatHealsException extends Exception{

	public NullDiseasesThatHealsException() {
		super("The medical worker should heal one disease at least.");
	}

}
