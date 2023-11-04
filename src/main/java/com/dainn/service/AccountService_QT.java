package com.dainn.service;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.dainn.dto.AccountDTO;

public class AccountService_QT {

	public static List<AccountDTO> getAccount_QT() throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<AccountDTO> accounts = new ArrayList<AccountDTO>();
		
		try {
			connection = DBService_QT.getConnection();
			stmt = connection.createStatement();
			String query = "SELECT * FROM account";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				AccountDTO account = new AccountDTO();
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullName(rs.getString("fullname"));
				account.setStatus(rs.getInt("status"));
				account.setRoleId(rs.getString("role_id"));
				accounts.add(account);
			}
		} finally {
			DBService_QT.closeResourcesStatement(rs, stmt, connection);
		}
		return accounts;
	}
	
}
