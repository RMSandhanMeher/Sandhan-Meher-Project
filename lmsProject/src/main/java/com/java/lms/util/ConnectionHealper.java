package com.java.lms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHealper {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		ResourceBundle resources= ResourceBundle.getBundle("lms");
		String driver=resources.getString("driver");
		String url=resources.getString("url");
		String user=resources.getString("user");
		String password=resources.getString("password");
		
		Class.forName(driver);
		Connection conection = DriverManager.getConnection(url,user,password);
		return conection;
	}
}
