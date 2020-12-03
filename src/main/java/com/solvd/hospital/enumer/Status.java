package com.solvd.hospital.enumer;

public enum Status {
	FIXED("Fixed",1), 
	ACTIVE("Active",0),
	PENDING("Pending",-1);
	
	private String status;
	private int min;
	
	Status(String status, double min) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public double getMinimum() {
		return min;
	}

}
