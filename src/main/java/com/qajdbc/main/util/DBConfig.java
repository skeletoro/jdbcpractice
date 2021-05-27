package com.qajdbc.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.qajdbc.main.DBConnection;

public class DBConfig {
	public final static String url = "jdbc:mysql://localhost:3306/maventest";
	public final static String username = "root";
	public final static String password = "root";
	private static Connection connection;
	private static DBConnection instance;

	private DBConfig(Connection connection) {
		DBConnection.con = connection;

	}

	public static Connection getConnection() {

		if (instance == null) {

		}
		try {
			connection = DriverManager.getConnection(url, username, password);
			instance = new DBConnection();

			System.out.println("Successfully connected");

		} catch (SQLException e) {
			System.out.println("Unable to connect, try again");
			e.printStackTrace();
		}
		return DBConnection.con;

	}

}
