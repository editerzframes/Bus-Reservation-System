package com.login.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.login.controller.Connection1;

@Service
public class LoginService {

	
	  public boolean validateUser(String userid, String password) throws SQLException, ClassNotFoundException {
	    	
		Connection conn = (Connection) Connection1.conn();
	 	   String insert = "Select * from login;";
	 	  Statement stmt = conn.createStatement();
	 	  ResultSet rs = stmt.executeQuery(insert);
	 	 
	 	  while (rs.next()) {    
	 	          
	 	           String firstname = rs.getString("username");
	 	           String lastname = rs.getString("password");
	 	          if( userid.equalsIgnoreCase(firstname)
	 	                 && password.equalsIgnoreCase(lastname)) {
	 	         	return true;
	 	         }
	 	        }
		return false;
	 	  
	       
	    }

	public int checkIfExist(String name) throws SQLException, ClassNotFoundException {
		Connection conn = (Connection) Connection1.conn();
	 	   String insert = "Select * from login;";
	 	  Statement stmt = conn.createStatement();
	 	  ResultSet rs = stmt.executeQuery(insert);
	 	 int count = 0;
	 	  while (rs.next()) {    
	 	          
	 	           String firstname = rs.getString("username");
	 	          if( name.equalsIgnoreCase(firstname)) {
	 	             count++;
	 	         }
	 	        }
		
	 	  
		return count;
	}
	
	public int checkIfNameExist(String name) throws SQLException, ClassNotFoundException {
		Connection conn = (Connection) Connection1.conn();
	 	   String insert = "Select * from tickets;";
	 	  Statement stmt = conn.createStatement();
	 	  ResultSet rs = stmt.executeQuery(insert);
	 	 int count = 0;
	 	  while (rs.next()) {    
	 	          
	 	           String firstname = rs.getString("name");
	 	          if( name.equalsIgnoreCase(firstname)) {
	 	             count++;
	 	         }
	 	        }
		
	 	  
		return count;
	}
	
	public int checkAvailability(String des) throws SQLException, ClassNotFoundException {
		Connection conn = (Connection) Connection1.conn();
	 	   String insert = "Select * from destinations where name = '"+des+"';";
	 	  Statement stmt = conn.createStatement();
	 	  ResultSet rs = stmt.executeQuery(insert);
	 	 int count = 0;
	 	  while (rs.next()) {    
	 	          
	 	           count = rs.getInt("ava");
	 	         
	 	        }
		
	 	  
		return count;
	}

	public void enterData(String name, String des, int num_pass, int num_passdiss) throws SQLException, ClassNotFoundException {
		Connection conn = (Connection) Connection1.conn();
		String insert1 = "Select * from destinations where name = '"+des+"';";
	 	  Statement stmt = conn.createStatement();
	 	  ResultSet rs = stmt.executeQuery(insert1);
	 	 int count = 0;
	 	 int ava = 0;
	 	  while (rs.next()) {    
	 	          
	 	           count = rs.getInt("price");
	 	         ava = rs.getInt("ava");
	 	        }
	 	  
		int ui = num_passdiss;
		int total = 0;
		for(int i = 0; i < num_pass; i++) {
			if(ui > 0) {
				total += count - (count*0.2);
			}
			else {
				total += count;
			}
			ui--;
		}
		
		String insert = "INSERT INTO tickets (name, des, num_pass, num_passdiss, total) VALUES ('"
				+ name + "', '" + des +"', '" + num_pass + "', '" + num_passdiss + "', '" + total + "');";
		Statement stat = conn.createStatement();
		stat.executeUpdate(insert);
		ava = ava - num_pass;
		String insert2 = "UPDATE destinations SET ava = '" + ava + "' where name = '" + des + "';";
		Statement stat2 = conn.createStatement();
		stat2.executeUpdate(insert2);
	}

	 public boolean alreadyExist(String userid) throws SQLException, ClassNotFoundException {
	    	
			Connection conn = (Connection) Connection1.conn();
		 	   String insert = "Select * from tickets;";
		 	  Statement stmt = conn.createStatement();
		 	  ResultSet rs = stmt.executeQuery(insert);
		 	 
		 	  while (rs.next()) {    
		 	          
		 	           String firstname = rs.getString("name");
		 	          if( userid.equalsIgnoreCase(firstname)) {
		 	         	return true;
		 	         }
		 	        }
			return false;
		 	  
		       
		    }
	 
	 public int paid(String userid) throws SQLException, ClassNotFoundException {
	    	
			Connection conn = (Connection) Connection1.conn();
		 	   String insert = "Select * from tickets where name = '"+userid+"';";
		 	  Statement stmt = conn.createStatement();
		 	  ResultSet rs = stmt.executeQuery(insert);
		 	 int pay = 0;
		 	  while (rs.next()) {    
		 	          
		 	         pay = rs.getInt("total");
		 	         
		 	        }
			return pay;
		 	  
		       
		    }
	 static String name22 = " ";
	 public void setName(String userid){
	    	
			name22 = userid;
		    }
	 public static String getName(){
	    	return name22;
		    }
	 
	 static String name23 = " ";
	 public void setName2(String userid){
	    	
			name23 = userid;
		    }
	 public static String getName2(){
	    	return name23;
		    }
	 
	 public void donepaid(String userid) throws SQLException, ClassNotFoundException {
	    	int u = 0;
			Connection conn = (Connection) Connection1.conn();
			String insert2 = "UPDATE tickets SET total = '" + u + "' where name = '" + userid + "';";
			Statement stat2 = conn.createStatement();
			stat2.executeUpdate(insert2);
		 	  
		       
		    }
	 
	 public void cancel(String userid) throws SQLException, ClassNotFoundException {
	    	
			Connection conn = (Connection) Connection1.conn();
			String insert = "DELETE FROM tickets where name = '" + userid + "';";
			Statement stat = conn.createStatement();
			stat.executeUpdate(insert);
		 	  
		       
		    }
	 
}
