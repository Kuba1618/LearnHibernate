package com.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDatabase {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_ultimate_bykowski?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,user,password);
			
			System.out.println("Connection successfull !!!");
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}

}
