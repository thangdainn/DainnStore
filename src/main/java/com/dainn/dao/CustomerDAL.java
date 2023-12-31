package com.dainn.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dainn.dto.CustomerDTO;

public class CustomerDAL {

	private static Connection connection = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;

	public static List<CustomerDTO> getCustomer_QT() throws SQLException {
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();

		try {
			connection = DatabaseAccess.getConnection();
			String query = "SELECT * FROM customer WHERE status = 1";
			stmt = connection.prepareStatement(query);

			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("fullname"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setPoints(rs.getInt("points"));
				customers.add(customer);
			}
		} finally {
			DatabaseAccess.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return customers;
	}

	public static void updateCustomer(CustomerDTO customer) throws SQLException {
		try {
			connection = DatabaseAccess.getConnection();
			String query = "UPDATE customer SET fullname = ?, address = ?, phone= ?, points = ? WHERE id = ?";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getAddress());
			stmt.setString(3, customer.getPhone());
			stmt.setInt(4, customer.getPoints());
			stmt.setInt(5, customer.getId());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DatabaseAccess.closeResourcesPreparedStatement(stmt, connection, null);
		}
	}

	public static void deleteCustomer(CustomerDTO customer) throws SQLException {
		try {
			connection = DatabaseAccess.getConnection();
			String query = "UPDATE customer SET status = ? WHERE id = ?";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, customer.getStatus());
			stmt.setInt(2, customer.getId());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Đã xóa!");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DatabaseAccess.closeResourcesPreparedStatement(stmt, connection, null);
		}
	}

	public static List<CustomerDTO> getFindCustomer_QT(String find) throws SQLException {
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();

		try {
			connection = DatabaseAccess.getConnection();
			String query = "SELECT * FROM customer WHERE status = 1 AND (id = ? OR fullname LIKE ? OR phone = ?)";
			
			stmt = connection.prepareStatement(query);
			stmt.setString(1, find);
			stmt.setString(2, "%" + find + "%");
			stmt.setString(3, find);

			rs = stmt.executeQuery();
			while (rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("fullname"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddress(rs.getString("address"));
				customer.setPoints(rs.getInt("points"));
				customers.add(customer);
//				System.out.println(find +customer);
			}
		} finally {
			DatabaseAccess.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return customers;
	}
}
