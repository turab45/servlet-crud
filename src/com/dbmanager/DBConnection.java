package com.dbmanager;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DBConnection {

	public static Connection conn = null;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student-form", "root", "root");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return conn;
	}
}
