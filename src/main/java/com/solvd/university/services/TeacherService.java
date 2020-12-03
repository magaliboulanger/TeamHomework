package com.solvd.university.services;

import java.util.List;

import com.solvd.university.dao.*;
import com.solvd.university.dao.mysql.*;
import com.solvd.university.model.*;

public class TeacherService {

	private ITeacherDAO tdao;
	private PersonService pserv;
	private IAddressDAO adao;
	
	public TeacherService() {
		this.tdao = new TeacherDAO();
		this.pserv = new PersonService();
		this.adao = new AddressDAO();
	}
	
	public Teacher getById(Long id) {
		Teacher teacher = tdao.getById(id);
		Person person = pserv.getById(id);
		teacher.setAddress(person.getAddress());
		teacher.setEmail(person.getEmail());
		teacher.setName(person.getName());
		teacher.setPhone(person.getPhone());
		return teacher;
	}
	
	public List<Teacher> getTeachersByDepartment(Long id) {
		List<Teacher> teachers = tdao.getByDepartmentId(id);
		for (Teacher t:teachers) {
			Person person = pserv.getById(t.getId());
			t.setAddress(person.getAddress());
			t.setEmail(person.getEmail());
			t.setName(person.getName());
			t.setPhone(person.getPhone());
		}
		
		return teachers;
	}
}
