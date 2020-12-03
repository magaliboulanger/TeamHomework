package com.solvd.university.model;

import java.util.Date;

public class ReservationRoom extends AbstractEntity {

	private Room r;
	private Teacher t;
	private Date start;
	private Date finish;
	public ReservationRoom(long id, Room r, Teacher t, Date start, Date finish) {
		super(id);
		this.r = r;
		this.t = t;
		this.start = start;
		this.finish = finish;
	}
	public ReservationRoom() {
		super();
		this.r=null;
		this.finish=null;
		this.start=null;
		this.t=null;
	}
	public Room getR() {
		return r;
	}
	public void setR(Room r) {
		this.r = r;
	}
	public Teacher getT() {
		return t;
	}
	public void setT(Teacher t) {
		this.t = t;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getFinish() {
		return finish;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
}
