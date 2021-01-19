package com.login.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {

	  public static Connection conn() throws SQLException, ClassNotFoundException {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3307/busres?allowPublicKeyRetrieval=true&useSSL=false",
		        "root", "Facebook@900"); 	
		    
		    return conn;
	  }
}
