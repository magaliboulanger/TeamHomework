package com.solvd.university.model;

public abstract class AbstractEntity {
	private long id;

	public AbstractEntity(long id) {
		super();
		this.id = id;
	}
	
	public AbstractEntity() {
		this.id = 0;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
}
