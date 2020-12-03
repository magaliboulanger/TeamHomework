package com.solvd.hospital.model.hospital;

import java.util.ArrayList;
import java.util.Date;

import com.solvd.hospital.interfaces.Operable;
import com.solvd.hospital.model.Record;

public class Machine implements Operable {

	private String name;
	private Date dateOfPurchase;
	private ArrayList<Record> records;
	
	public Machine(String name, Date dop) {
		this.name = name;
		this.dateOfPurchase = dop;
	}
	
	public Machine () {
		this.name = null;
		this.dateOfPurchase = null;
	}
	
	public void operate() {
		//TODO
	}
	
	public void searchRecord() {
		//TODO
	}
	public void repare() {
		//todo
	}
	
	public void record() {
		//todo
	}



}
