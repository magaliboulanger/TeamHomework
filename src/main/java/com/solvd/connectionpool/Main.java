package com.solvd.connectionpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

	private static Logger l= LogManager.getLogger(Main.class);
	public static void main(String[] args ) {
		ExecutorService ex=Executors.newFixedThreadPool(10);
		MyConnectionPool pool = MyConnectionPool.getInstance();


		ex.shutdown();
		try {
			ex.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			l.error(e);
		}
	}
}
