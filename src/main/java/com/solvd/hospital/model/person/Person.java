package com.solvd.hospital.model.person;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.hospital.exceptions.InvalidIdentifierException;

public abstract class Person  {

	private int id;
	private String name;
	private String phoneNumber;
	private String address;
	private static Logger l= LogManager.getLogger(Person.class);
	
	//constructors
	public Person(int id, String name, String phoneNumber, String address) {
		
		try {
			this.setId(id);
		} catch (InvalidIdentifierException e) {
			l.error(e);
		}
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public Person() {
		this.address=null;
		this.id=-1;
		this.name=null;
		this.phoneNumber=null;
	}	
	
	//getters and setters 
	public int getId() { return id;	}
	
	
	public void setId(int id) throws InvalidIdentifierException { 
		if (id<0)
			throw new InvalidIdentifierException();
		this.id = id; }
	
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name;}
	public String getPhoneNumber() { return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	
	@Override
	public int hashCode() { return Objects.hash(address, id, name, phoneNumber); }
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.hashCode()!= this.hashCode())
			return false;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

	public void operate() {	/*to do*/}
	
}
