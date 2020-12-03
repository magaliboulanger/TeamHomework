package com.solvd.university.model;

import java.util.List;

public class Study  extends AbstractEntity {
	private Teach teach;
	private Student student;
	private List<Exam> exams;
	public Study(long id, Student student,Teach t, List<Exam> exams) {
		super(id);
		this.student = student;
		this.teach = teach;
		this.exams = exams;
	}
	public Study() {
		super();
		this.exams=null;
		this.student=null;
		this.teach=null;
	}
	public Teach getTeach() {
		return teach;
	}
	public void setTeach(Teach teach) {
		this.teach = teach;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public List<Exam> getExams() {
		return exams;
	}
	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}
	@Override
	public String toString() {
		return "Study [teach=" + teach + ", student=" + student + ", exams=" + exams + "]";
	}
	
	
}
