package com.solvd.university.model;

public class Subject extends AbstractEntity {
	private String name;
	private int hours;
	private int credits;
	private Department depto;
	public Subject(long id, String name, int hours, int credits, Department d) {
		super(id);
		this.name = name;
		this.hours = hours;
		this.credits = credits;
		this.depto=d;
	}
	public Subject(long id, String name, int hours, int credits) {
		super(id);
		this.name = name;
		this.hours = hours;
		this.credits = credits;
	}
	public Subject() {
		super();
		this.credits=0;
		this.depto=null;
		this.hours=0;
		this.name=null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHours() {
		return hours;
	}
	public Department getDepto() {
		return depto;
	}
	public void setDepto(Department depto) {
		this.depto = depto;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return "Subject [name=" + name + ", hours=" + hours + ", credits=" + credits + "]";
	}
	
	
}
