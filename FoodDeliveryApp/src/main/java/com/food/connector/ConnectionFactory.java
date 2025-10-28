package com.food.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String url ="jdbc:mysql://localhost:3306/food_delevery_app";
	private static final String uName="root";
	private static final String uPwd="Shanmukhasai43@";
	
	public static Connection requestConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uName, uPwd);
		return con;
	}
	
}
