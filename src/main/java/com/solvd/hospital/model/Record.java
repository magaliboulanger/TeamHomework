package com.solvd.hospital.model;

import java.util.Date;

import com.solvd.hospital.interfaces.IRegister;
import com.solvd.hospital.interfaces.Reparable;

public class Record  {
	private Date date;
	private IRegister repairman;
	private Reparable repaired;
	
	public Record(Date date, IRegister repairman, Reparable repaired) {
		super();
		this.date = date;
		this.repairman = repairman;
		this.repaired = repaired;
	}
	
	


}
