package com.solvd.hospital.model;


import java.util.Date;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hospital.exceptions.NullDateException;
import com.solvd.hospital.model.hospital.RoomWithReservation;
import com.solvd.hospital.model.person.Doctor;
import com.solvd.hospital.model.person.Patient;

public class Appointment {
	private RoomWithReservation room;
	private Patient patient;
	private Doctor doctor;
	private Date date;

	private static Logger l= LogManager.getLogger(Appointment.class);
	//constructors
	public Appointment(RoomWithReservation room, Patient patient, Date date, Doctor doctor) {
		this.room = room;
		this.patient = patient;
		
		try {
			this.setDate(date);
		} catch (NullDateException e) {
			// TODO Auto-generated catch block
			l.error(e);
		}
		this.doctor = doctor;
	}
	
	public Appointment() {
		this.room = null;
		this.date = null;
		this.patient = null;
		this.doctor = null;
	}
	
	
	//getters and setters
	public RoomWithReservation getRoom() {
		return room;
	}
	public void setRoom(RoomWithReservation room) {
		this.room = room;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) throws NullDateException {
		if (date==null)
			throw new NullDateException();
		this.date = date;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Appointment [room=" + room + ", patient=" + patient + ", doctor=" + doctor + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(doctor, date, patient, room);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Appointment))
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(doctor, other.doctor) && Objects.equals(date, other.date)
				&& Objects.equals(patient, other.patient) && Objects.equals(room, other.room);
	}
	
	
	
	
	
	
	
}
