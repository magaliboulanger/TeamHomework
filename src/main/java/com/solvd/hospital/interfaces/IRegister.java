package com.solvd.hospital.interfaces;

import java.util.Date;
@FunctionalInterface
public interface IRegister {

	public void record(Date date, Reparable m);
}
