package com.solvd.university.dao;


import com.solvd.university.model.Room;

public interface IRoomDAO extends DAO<Room, Long>{

	Room save(Room b);

}
