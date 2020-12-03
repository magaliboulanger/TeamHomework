package com.solvd.hospital.enumer;

public enum Level {
	
	LOW("Low", 30),
	MEDIUM("Medium", 50), 
	HIGH("High", 80);

	private String level;
	private double minimum;
	
	Level(String level, double minimum) {
		this.level = level;
	}

	public String getLevel() {
		return level;
	}

	public double getMinimum() {
		return minimum;
	}

}
