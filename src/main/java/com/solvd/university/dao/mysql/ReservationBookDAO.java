package com.solvd.university.dao.mysql;

import java.util.List;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.IReservationBookDAO;
import com.solvd.university.model.ReservationBook;

public class ReservationBookDAO extends MySQLDAO implements IReservationBookDAO{

	

	@Override
	public ReservationBook save(ReservationBook b) {
		// TODO Auto-generated method stub
		return new ReservationBook();
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReservationBook getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationBook> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
