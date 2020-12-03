package com.solvd.university.model;

public class Address extends AbstractEntity {

	private String addr;
	private int coords;
	public Address(long id, String addr, int coor) {
		super(id);
		this.addr = addr;
		this.coords = coor;
	}
	@Override
	public String toString() {
		return "Address [addr=" + addr + ", coords=" + coords + "]";
	}
	public Address() {
		this.addr = null;
		this.coords = 0;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getCoords() {
		return coords;
	}
	public void setCoords(int coords) {
		this.coords = coords;
	}
	
}
