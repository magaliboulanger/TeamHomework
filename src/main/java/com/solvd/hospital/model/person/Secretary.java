package com.solvd.hospital.model.person;


import java.util.Date;

import com.solvd.hospital.interfaces.IBook;
import com.solvd.hospital.interfaces.ISearchRecord;
import com.solvd.hospital.model.Appointment;
import com.solvd.hospital.model.hospital.RoomWithReservation;

public class Secretary extends HospitalWorker implements  ISearchRecord, IBook{

	public Secretary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Secretary(int id, String name, String phoneNumber, String address, Double salary) {
		super(id, name, phoneNumber, address, salary);
		// TODO Auto-generated constructor stub
	}

	public void createApointment() {
		//secretary will be able to appoint new dates and save them in the doctor's appointments, and in the RoomWithReservation's appointments
	}
	
	public void modifyAppointment() {
		//secretary will be able to modify dates.
	}
	
	public void removeAppointment() {
		//secretary will be able to delete dates
	}
	
	@Override
	public void searchRecord() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void book(RoomWithReservation r, Doctor d, Patient p, Date date, IBook b) {
		b.book(r, d, p, date, b);
		
	}


}
