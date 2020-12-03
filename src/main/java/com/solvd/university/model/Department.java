package com.solvd.university.model;

import java.util.List;

public class Department extends AbstractEntity {
	private String name;
	private List<Teacher> teachers;
	
	public Department(long id, String name, List<Teacher> teachers) {
		super(id);
		this.name = name;
		this.teachers=teachers;
	}
	
	public Department() {
		super();
		this.name = null;
		this.teachers = null;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
	@Override
	public String toString() {
		return "Department [name=" + name + ", teachers=" + teachers + "]";
	}
	
}
