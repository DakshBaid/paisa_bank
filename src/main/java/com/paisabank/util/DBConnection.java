package com.paisabank.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
private static Connection con=null;
private static String url="jdbc:mysql://localhost:3306/paisa_bank";
private static String user="root";
private static String password="root";
private DBConnection() {}
public static Connection getConnection() {
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(con==null || con.isClosed()) {
			con=DriverManager.getConnection(url,user,password);
			
		
		System.out.println("Database Connected Successfully.");
	}
	}catch(Exception e) {

	    System.out.println("Database Connection Failed!");
		e.printStackTrace();
	}
	return con;
}
}