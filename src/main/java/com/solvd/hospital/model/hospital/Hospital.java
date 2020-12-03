package com.solvd.hospital.model.hospital;


import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.solvd.hospital.model.person.HospitalWorker;

public class Hospital {
	private String name;
	private String address;
	private String city;
	private List<HospitalWorker> workers;
	private List<Area> areas;
	private List<Ambulance> ambulances;
	private Date dateOfFundation;
	
	//constuctors
	public Hospital(String name, String address, List<HospitalWorker> workers, List<Area> areas, String city, List<Ambulance> amb, Date d) {
		this.name = name;
		this.address = address;
		this.workers = workers;
		this.areas = areas;
		this.city = city;
		this.ambulances = amb;
		this.dateOfFundation = d; 
	}
	public Hospital () {
		this.name=null;
		this.address=null;
		this.workers=null;
		this.areas=null;
		this.city = null;
		this.ambulances = null;
		this.dateOfFundation=null;
	}

	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getAddress()  { return address; }
	public void setAddress(String address) { this.address = address; }
	public List<HospitalWorker> getWorkers() { return workers; }
	public void setWorkers(List<HospitalWorker> workers) { this.workers = workers; }
	public List<Area> getAreas() { return areas; }
	public void setAreas(List<Area> areas) { this.areas = areas; }
	
	@Override
	public String toString() {
		return "Hospital [name=" + name + ", address=" + address + ", city=" + city + ", workers="
				+ workers.toString() + ", areas=" + areas.toString() + ", getCity()=" + getCity()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress() + ", getWorkers()="
				+ getWorkers().toString() + ", getAreas()=" + getAreas().toString()+ ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	@Override
	public int hashCode() {	return Objects.hash(name, address, city); }
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.hashCode()!= this.hashCode())
			return false;
		if (!(obj instanceof Hospital))
			return false;
		Hospital other = (Hospital) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
	
		return true;
	}
	
	
}
