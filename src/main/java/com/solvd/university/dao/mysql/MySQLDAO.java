package com.solvd.university.dao.mysql;

import com.solvd.connectionpool.MyConnectionPool;

public abstract class MySQLDAO {

	protected MyConnectionPool connection = MyConnectionPool.getInstance();
	
}
