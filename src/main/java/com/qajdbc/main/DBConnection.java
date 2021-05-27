package com.qajdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.qajdbc.main.util.DBConfig;

public class DBConnection {

	private static PreparedStatement ps;
	public static Connection con;
	private static ResultSet rs;

	public DBConnection() throws SQLException {
		con = DriverManager.getConnection(DBConfig.url, DBConfig.username, DBConfig.password);

	}

	public static void create(int id, String fName, String lName) throws SQLException {
		String q = "INSERT INTO CUSTOMERS (customer_id, first_name,last_name) VALUES (?, ?,?)";
		ps = con.prepareStatement(q);
		ps.setInt(1, id);
		ps.setString(2, fName);
		ps.setString(3, lName);
		ps.execute();

	}

	public void readSingle(int id) throws SQLException {
		String q = "SELECT customer_id, first_name,last_name FROM CUSTOMERS where customer_id = ?";
		ps = con.prepareStatement(q);
		ps.setInt(1, id);
		rs = ps.executeQuery();

		while (rs.next()) {
			System.out.println(String.format("Customer ID: %d, first name: %s, last name: %s", rs.getInt("customer_id"),
					rs.getString("first_name"), rs.getString("last_name")));

		}
	}

	public static void read() throws SQLException {
		String q = "SELECT * FROM CUSTOMERS;";

		Statement statement = con.createStatement();
		rs = statement.executeQuery(q);

		while (rs.next()) {
			System.out.println(String.format("Customer ID: %d, first name: %s, last name: %s", rs.getInt("customer_id"),
					rs.getString("first_name"), rs.getString("last_name")));

		}

	}

	public static void update(int id, String fName, String lName) throws SQLException {
		String q = "UPDATE CUSTOMERS Set first_name = ?,last_name=? WHERE customer_id = ?;";
		ps = con.prepareStatement(q);
		ps.setInt(3, id);
		ps.setString(1, fName);
		ps.setString(2, lName);
		ps.executeUpdate();

	}

	public static void delete(int id) throws SQLException {
		String q = "delete from customers where customer_id = ?;";
		ps = con.prepareStatement(q);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}
