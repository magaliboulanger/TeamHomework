package com.solvd.hospital.exceptions;

public class SalaryZeroException extends Exception {

	public SalaryZeroException() {
		super("Salary should be greater than zero.");
	}
}
