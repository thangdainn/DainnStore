package com.dainn.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dainn.dto.Account_QT;

public class AccountService_QT {

	public static List<Account_QT> getAccount_QT() throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Account_QT> accounts = new ArrayList<Account_QT>();
		try {
			connection = DBService_QT.getConnection();
			stmt = connection.createStatement();
			String query = "SELECT * FROM account";
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				Account_QT Account_QT = new Account_QT();
				Account_QT.setId(rs.getInt("id"));
				Account_QT.setUsername(rs.getString("username"));
				Account_QT.setPassword(rs.getString("password"));
				Account_QT.setFullName(rs.getString("fullname"));
//				Account_QT.setPhone(rs.getString("phone"));
//				Account_QT.setAddress(rs.getString("address"));
//				Account_QT.setStatus(rs.getInt("status"));
				Account_QT.setRoleId(rs.getString("role_id"));
			}
		} finally {
			DBService_QT.closeResourcesStatement(rs, stmt, connection);
			JOptionPane.showMessageDialog(null, "Success!");
		}
		return accounts;
	}
	
}
