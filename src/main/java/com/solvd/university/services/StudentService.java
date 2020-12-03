package com.solvd.university.services;

import com.solvd.university.dao.*;
import com.solvd.university.dao.mysql.*;
import com.solvd.university.model.*;

public class StudentService {

	private IStudentDAO sdao;
	private PersonService pserv;
	private IAddressDAO adao;
	
	public StudentService() {
		this.sdao = new StudentDAO();
		this.pserv = new PersonService();
		this.adao = new AddressDAO();
	}
	
	public Student getById(Long id) {
		Student student = sdao.getById(id);
		Person person = pserv.getById(id);
		student.setAddress(person.getAddress());
		student.setEmail(person.getEmail());
		student.setName(person.getName());
		student.setPhone(person.getPhone());
		return student;
	}
	
}
