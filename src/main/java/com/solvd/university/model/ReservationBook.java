package com.solvd.university.model;

import java.util.Date;

public class ReservationBook extends AbstractEntity {
	private Book book;
	private Student student;
	private Date date;
	private Date end;
	public ReservationBook(long id, Book book, Student student, Date date, Date end) {
		super(id);
		this.book = book;
		this.student = student;
		this.date = date;
		this.end = end;
	}
	
	public ReservationBook() {
		super();
		this.book=null;
		this.date=null;
		this.end=null;
		this.student=null;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	
	
}
