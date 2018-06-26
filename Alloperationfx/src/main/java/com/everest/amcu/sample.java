package com.everest.amcu;

import java.sql.*;

public class sample {

	// public static void main(String[] args) {
	//
	// try {
	// sample s = new sample();
	// s.simplemethod();
	//
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// System.out.println(e.getLocalizedMessage());
	// }
	//
	// }
	//
	// public void simplemethod() throws Exception {
	//
	// Class.forName("com.mysql.jdbc.Driver");
	// Connection con =
	// DriverManager.getConnection("jdbc:mysql://localhost:3399/0040008_attachment",
	// "root",
	// "nd0040008d");
	// System.out.println("okkk");
	//
	// }
	public static void main(String args[]) {
		Multi mul = new Multi();
		
		Thread t1 = new Thread(mul);
		Thread t2 = new Thread(mul);

		t1.setName("t1");
		// t1.setDaemon(true);
		t2.setName("t2");

		t1.start();
		t2.run();
	}

}

class Multi implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(" : " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}