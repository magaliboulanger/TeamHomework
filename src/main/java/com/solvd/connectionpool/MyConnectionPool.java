package com.solvd.connectionpool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyConnectionPool {

	private static Logger l= LogManager.getLogger(MyConnectionPool.class);
	private final int MAX_SIZE=10;
	private AtomicInteger usedConnections;
	private BlockingQueue<Connection> connectionPool;
	private static MyConnectionPool instanceMCP=null;

	private MyConnectionPool() {
		this.connectionPool=new ArrayBlockingQueue<Connection>(MAX_SIZE);
		this.usedConnections = new AtomicInteger();
		this.usedConnections.set(0);
	}

	public static MyConnectionPool getInstance() {
		if(instanceMCP==null)
			instanceMCP = new MyConnectionPool();
		return instanceMCP;
	}

	public Connection getConnection() throws InterruptedException{
		synchronized(MyConnectionPool.class) {
			if(usedConnections.get()<MAX_SIZE)
			{
				try {
					Properties prop = new Properties();
					prop.load(new FileInputStream("src/main/resources/database.properties"));
					Class.forName(prop.getProperty("DRIVER")).newInstance();
					connectionPool.put(DriverManager.getConnection(prop.getProperty("URL")+prop.getProperty("DB_NAME"),prop.getProperty("USER_NAME"), prop.getProperty("PASSWORD")));
				} catch (InterruptedException | SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					l.error(e);
				}
				usedConnections.addAndGet(1);
			}
				
		}
		return connectionPool.take();

	}



	public boolean releaseConnection(Connection connection) throws InterruptedException {
		connectionPool.put(connection);
		usedConnections.decrementAndGet();
		return true;
	}


	public void closeAll() {
		connectionPool.stream().filter(c->c!=null).forEach(c->{
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		connectionPool.clear();
		usedConnections.set(0);;
	}
}
