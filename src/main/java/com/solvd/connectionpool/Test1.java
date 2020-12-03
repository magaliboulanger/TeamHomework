package com.solvd.connectionpool;

import java.sql.Connection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test1 extends Thread{

	private static Logger l= LogManager.getLogger(Main.class);
	private MyConnectionPool pool;
	private Connection con;
	
	public Test1(MyConnectionPool p)
	{
		this.pool=p;
	}
	
	@Override 
	public void run() {
		try {
			con = pool.getConnection();
			l.info("Connection was obtained.");
			Thread.sleep(5000);
			l.info("Connection was free.");
			pool.releaseConnection(con);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			l.error("",e);
		}
	}
	
}
