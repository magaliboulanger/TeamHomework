package com.solvd.university.model;

public class Mark extends AbstractEntity {

	private String mark;
	private float numberMark;
	
	public Mark(long id, String mark, float numberMark) {
		super(id);
		this.mark = mark;
		this.numberMark = numberMark;
	}

	public Mark () {
		super();
		this.mark=null;
		this.numberMark=0;
	}
	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public float getNumberMark() {
		return numberMark;
	}

	public void setNumberMark(float numberMark) {
		this.numberMark = numberMark;
	}
	
	
}
