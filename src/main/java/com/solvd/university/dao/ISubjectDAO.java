package com.solvd.university.dao;


import com.solvd.university.model.Subject;


public interface ISubjectDAO extends DAO<Subject, Long> {
	Subject save(Subject b);
	
}
