package com.solvd.hospital.interfaces;
import java.util.Date;
import com.solvd.hospital.model.hospital.RoomWithReservation;
import com.solvd.hospital.model.person.Doctor;
import com.solvd.hospital.model.person.Patient;

@FunctionalInterface
public interface IBook {

	void book(RoomWithReservation r, Doctor d, Patient p, Date date, IBook b);
	
}
