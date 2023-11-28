package com.dainn.dao;

import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseAccess {

	private static final String url = "jdbc:mysql://localhost:3306/dainnstore";
	private static final String username = "root";
	private static final String password = "";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void closeResourcesPreparedStatement(PreparedStatement stmt, Connection connection, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
