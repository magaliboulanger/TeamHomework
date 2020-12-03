package com.solvd.university.dao;

import java.util.List;

import com.solvd.university.model.Exam;

public interface IExamDAO extends DAO<Exam, Long>{
	Exam save(Exam b, long stuId);
	List<Exam> getByStudyId(long id);
}
