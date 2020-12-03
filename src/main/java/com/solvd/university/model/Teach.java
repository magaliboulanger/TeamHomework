package com.solvd.university.model;

public class Teach extends AbstractEntity{
	
	private Teacher teacher;
	private Subject subject;
	public Teach(long id, Teacher teacher, Subject subject) {
		super(id);
		this.teacher = teacher;
		this.subject = subject;
	}
	public Teach() {
		super();
		this.subject=null;
		this.teacher=null;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Teach [teacher=" + teacher + ", subject=" + subject + "]";
	}
}
