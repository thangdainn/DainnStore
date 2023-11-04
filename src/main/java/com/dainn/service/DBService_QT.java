package com.dainn.service;

import java.sql.*;

import javax.swing.JOptionPane;

public class DBService_QT {

	private static final String url = "jdbc:mysql://localhost:3306/dainnstore";
	private static final String username = "root";
	private static final String password = "12345";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	public static void closeResourcesPreparedStatement(PreparedStatement stmt, Connection connection) {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}

	public static void closeResourcesStatement(ResultSet rs, Statement stmt, Connection connection) {
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
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}
}
