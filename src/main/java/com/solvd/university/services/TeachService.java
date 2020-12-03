package com.solvd.university.services;

import com.solvd.university.dao.*;
import com.solvd.university.dao.mysql.*;
import com.solvd.university.model.Teach;

public class TeachService {
	private ITeacherDAO tdao;
	private ITeachDAO tedao;
	private ISubjectDAO sdao;
	public TeachService() {
		super();
		tdao = new TeacherDAO();
		sdao =  new SubjectDAO();
		tedao = new TeachDAO();
	}
	
	public Teach getById(long id) {
		Teach out=tedao.getById(id);
		out.setSubject(sdao.getById(tedao.getSubjIdById(id)));
		out.setTeacher(tdao.getById(tedao.getTeacherIdById(id)));
		return out;
	}
}
