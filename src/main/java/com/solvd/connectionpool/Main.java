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
		Test1 t11 =new Test1(pool);
		Test2 t21 =new Test2(pool);
		Test1 t12 =new Test1(pool);
		Test2 t22 =new Test2(pool);
		Test1 t13 =new Test1(pool);
		Test2 t23 =new Test2(pool);
		ex.execute(t11);
		ex.execute(t12);
		ex.execute(t13);
		ex.execute(t21);
		ex.execute(t22);
		ex.execute(t23);

		ex.shutdown();
		try {
			ex.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			l.error(e);
		}
	}
}
