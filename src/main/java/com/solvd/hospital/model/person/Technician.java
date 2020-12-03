package com.solvd.hospital.model.person;

import java.util.Date;

import com.solvd.hospital.interfaces.IRegister;
import com.solvd.hospital.interfaces.ISearchRecord;
import com.solvd.hospital.interfaces.Reparable;
import com.solvd.hospital.model.Record;

public class Technician extends HospitalWorker implements IRegister, ISearchRecord{

	public Technician() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Technician(int id, String name, String phoneNumber, String address, Double salary) {
		super(id, name, phoneNumber, address, salary);
		// TODO Auto-generated constructor stub
	}
 
	@Override
	public void searchRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void record(Date date, Reparable m) {
		Record r = new Record(new Date(),this, m);
	}


}
