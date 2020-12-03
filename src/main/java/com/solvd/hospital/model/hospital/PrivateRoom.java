package com.solvd.hospital.model.hospital;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.solvd.hospital.exceptions.NullDirectorException;
import com.solvd.hospital.model.person.Administrator;
import com.solvd.hospital.model.person.HospitalWorker;

public class PrivateRoom <T extends HospitalWorker> extends Room {
	private List<T> admitted;
	private Administrator responsable;

	private static Logger l= LogManager.getLogger(PrivateRoom.class);
	public PrivateRoom(int id, String name, List<T> admitted, List<Machine> machs, Administrator responsable) {
		super(id, name, machs);
		this.admitted = admitted;
		try {
			this.setResponsable(responsable);
		} catch (NullDirectorException e) {
			// TODO Auto-generated catch block
			l.error(e);
		}
	}
	 
	public PrivateRoom() {
		super();
		this.admitted = null;
	}

	public Administrator getResponsable() {
		return responsable;
	}

	public void setResponsable(Administrator responsable) throws NullDirectorException {
		if(responsable==null)
			throw new NullDirectorException();
		else
			this.responsable = responsable;
	}

	public List<T> getAdmitted() {	return admitted; }
	public void setAdmitted(List<T> admitted) { this.admitted = admitted; }
	public void addAdmited(T p) { /* to do */	}
	public void removeAdmited(T p) { /* to do */ }
}
