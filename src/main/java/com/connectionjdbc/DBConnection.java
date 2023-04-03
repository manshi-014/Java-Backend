package com.connectionjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/grey_goose","root","root");
		return conn;
	}
}
