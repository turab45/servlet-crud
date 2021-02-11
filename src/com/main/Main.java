package com.main;

import java.sql.Connection;
import java.sql.ResultSet;

import com.dbmanager.DBConnection;
import com.mysql.jdbc.Statement;

public class Main {

	public static void main(String[] args) {
		Connection conn = DBConnection.getConnection();
		
		
		try {
		Statement stmt=(Statement) conn.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from student");  
		while(rs.next())  
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
		conn.close();  
		}catch(Exception e){ System.out.println(e);}  
		}  
		

	

}
