package com.solvd.university.dao.mysql;

import java.util.List;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.IReservationRoomDAO;
import com.solvd.university.model.ReservationRoom;

public class ReservationRoomDAO extends MySQLDAO implements IReservationRoomDAO  {

	

	@Override
	public ReservationRoom save(ReservationRoom b) {
		// TODO Auto-generated method stub
		return new ReservationRoom();
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ReservationRoom getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReservationRoom> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
