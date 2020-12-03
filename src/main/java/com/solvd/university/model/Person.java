package com.solvd.university.model;

public class Person extends AbstractEntity{
	private String name;
	private String phone;
	private Address address;
	private String email;
	public Person(long id, String name, String phone, Address address, String email) {
		super(id);
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email=email;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Person(long id, String name, String phone, String email) {
		super(id);
		this.name = name;
		this.phone = phone;
		this.email=email;
	}
	public Person() {
		super();
		this.address=null;
		this.email=null;
		this.name=null;
		this.phone=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
