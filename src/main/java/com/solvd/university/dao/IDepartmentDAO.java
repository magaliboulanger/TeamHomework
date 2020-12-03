package com.solvd.university.dao;


import com.solvd.university.model.Department;

public interface IDepartmentDAO extends DAO<Department, Long>{
	Department save(Department b);
}
