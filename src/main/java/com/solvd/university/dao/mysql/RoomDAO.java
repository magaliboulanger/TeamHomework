package com.solvd.university.dao.mysql;

import java.util.List;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.IRoomDAO;
import com.solvd.university.model.Room;

public class RoomDAO extends MySQLDAO implements IRoomDAO{

	
	@Override
	public Room save(Room b) {
		// TODO Auto-generated method stub
		return new Room();
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Room getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
