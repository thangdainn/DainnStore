package com.dainn.service;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import com.dainn.dto.CustomerDTO;

public class CustomerService_QT {

	public static List<CustomerDTO> getCustomer_QT() throws SQLException {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		
		try {
			connection = DBService_QT.getConnection();
			stmt = connection.createStatement();
			String query = "SELECT * FROM customer";
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				CustomerDTO customer = new CustomerDTO();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("fullname"));
				customer.setAddress(rs.getString("address"));
				customer.setPhone(rs.getString("phone"));
				customer.setPoints(rs.getInt("points"));
				customer.setStatus(rs.getInt("status"));
				customers.add(customer);
			}
		} finally {
			DBService_QT.closeResourcesStatement(rs, stmt, connection);
		}
		return customers;
	}
	
}
