package com.dainn.service;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dainn.dto.CustomerDTO;

public class CustomerService_QT {

	public static List<CustomerDTO> getCustomer_QT() throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();

		try {
			connection = DBService_QT.getConnection();
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
				customer.setStatus(rs.getInt("status"));
				customers.add(customer);
			}
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return customers;
	}

	public static void updateCustomer(CustomerDTO customer) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = DBService_QT.getConnection();
			String query = "UPDATE customer SET fullname = ?, address = ?, phone= ?, points = ? WHERE id = ?";
			
			stmt = connection.prepareStatement(query);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getAddress());
			stmt.setString(3, customer.getPhone());
			stmt.setInt(4, customer.getPoints());
			stmt.setInt(5, customer.getId());

			int rowsAffected = stmt.executeUpdate();
			if (rowsAffected > 0) {
				JOptionPane.showMessageDialog(null, "Đã cập nhật!");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, null);
		}
	}

	public static void deleteCustomer(CustomerDTO customer) throws SQLException {
		Connection connection = null;
		PreparedStatement stmt = null;
		try {
			connection = DBService_QT.getConnection();
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
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, null);
		}
	}
}
