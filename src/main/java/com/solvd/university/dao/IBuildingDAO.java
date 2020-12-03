package com.solvd.university.dao;


import com.solvd.university.model.Building;

public interface IBuildingDAO extends DAO<Building, Long>{
	Building save(Building b);
}
