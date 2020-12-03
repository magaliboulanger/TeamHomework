package com.solvd.university.dao;

import java.util.List;

import com.solvd.university.model.Teacher;

public interface ITeacherDAO extends DAO<Teacher, Long>{

	Teacher save(Teacher b, long idDepartment);
	List<Teacher> getByDepartmentId(long id);
}
