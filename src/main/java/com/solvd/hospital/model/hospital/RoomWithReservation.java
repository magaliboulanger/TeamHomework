package com.solvd.hospital.model.hospital;

import java.util.List;

import com.solvd.hospital.model.Appointment;

public class RoomWithReservation extends Room{

	private List<Appointment> apps;

	public RoomWithReservation(int id, String name, List<Appointment> apps, List<Machine> machs) {
		super(id, name, machs);
		this.apps = apps;
	}
	
	public RoomWithReservation() {
		super();
		this.apps = null;
	}
	
	public List<Appointment> getApps() { return apps; }
	public void setApps(List<Appointment> apps) { this.apps = apps;	}
	public void addAppointment(Appointment a) {	/*toDo*/	}
	public void removeAppointment(Appointment a) { /*toDo*/	}
}
