package com.dainn.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dainn.dto.AccountDTO;

public class AccountService_QT {

	private static Connection connection = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;

	public static List<AccountDTO> getAccount_QT() throws SQLException {
		List<AccountDTO> accounts = new ArrayList<AccountDTO>();

		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT * FROM account WHERE status = 1";
			stmt = connection.prepareStatement(query);

			rs = stmt.executeQuery();
			while (rs.next()) {
				AccountDTO account = new AccountDTO();
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullName(rs.getString("fullname"));
				account.setStatus(rs.getInt("status"));
				account.setRoleId(rs.getString("role_id"));
				account.setPhone(rs.getString("phone"));
				accounts.add(account);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return accounts;
	}

	public static List<AccountDTO> getFindAccount_QT(String find) throws SQLException {
		List<AccountDTO> accounts = new ArrayList<AccountDTO>();

		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT * FROM account WHERE status = 1 AND (username LIKE ? OR fullname LIKE ? OR phone = ? OR id = ?)";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, "%" + find + "%");
			stmt.setString(2, "%" + find + "%");
			stmt.setString(3, find);
			stmt.setString(4, find);

			rs = stmt.executeQuery();
			while (rs.next()) {
				AccountDTO account = new AccountDTO();
				account.setId(rs.getInt("id"));
				account.setUsername(rs.getString("username"));
				account.setPassword(rs.getString("password"));
				account.setFullName(rs.getString("fullname"));
				account.setStatus(rs.getInt("status"));
				account.setRoleId(rs.getString("role_id"));
				account.setPhone(rs.getString("phone"));
				accounts.add(account);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return accounts;
	}

	public static void insertAccount(AccountDTO account) throws SQLException {
		try {
			connection = DBService_QT.getConnection();
			String query = "INSERT INTO account (username, password, fullname, role_id, phone) VALUES (?, ?, ?, ?, ?)";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setString(3, account.getFullName());
			stmt.setString(4, account.getRoleId());
			stmt.setString(5, account.getPhone());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Tạo tài khoản thành công !");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, null);
		}
	}

	public static void updateAccount(AccountDTO account) throws SQLException {
		try {
			connection = DBService_QT.getConnection();
			String query = "UPDATE account SET username = ?, password = ?, fullname = ?, role_id = ?, phone = ? WHERE id = ?";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, account.getUsername());
			stmt.setString(2, account.getPassword());
			stmt.setString(3, account.getFullName());
			stmt.setString(4, account.getRoleId());
			stmt.setString(5, account.getPhone());
			stmt.setInt(6, account.getId());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, null);
		}
	}

	public static void deleteAccount(AccountDTO account) throws SQLException {
		try {
			connection = DBService_QT.getConnection();
			String query = "UPDATE account SET status = ? WHERE id = ?";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, account.getStatus());
			stmt.setInt(2, account.getId());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Đã xóa!");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, null);
		}
	}

	public static boolean isNameExistsInsert(String username) {
		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT username FROM account WHERE username = ? AND status = 1";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, username);

			rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
	}

	public static boolean isNameExistsUpdate(String username, int id) {
		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT username FROM account WHERE username = ? AND id != ? AND status = 1";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, username);
			stmt.setInt(2, id);

			rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
	}
}
