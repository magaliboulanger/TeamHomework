package com.solvd.university.dao.mysql;

import java.util.List;

import com.solvd.connectionpool.MyConnectionPool;
import com.solvd.university.dao.IMarkDAO;
import com.solvd.university.model.Mark;

public class MarkDAO extends MySQLDAO implements IMarkDAO {

	
	@Override
	public Mark save(Mark b) {
		// TODO Auto-generated method stub
		return new Mark();
	}

	@Override
	public boolean removeById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Mark getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Mark> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
