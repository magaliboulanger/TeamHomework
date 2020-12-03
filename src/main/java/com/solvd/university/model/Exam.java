package com.solvd.university.model;

import java.util.Date;

public class Exam  extends AbstractEntity {
	private String mark;
	private Date date;
	
	public Exam(long id, String mark, Date date) {
		super(id);
		this.mark = mark;
		this.date = date;
	}
	
	public Exam() {
		super();
		this.mark = null;
		this.date = null;
	}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
