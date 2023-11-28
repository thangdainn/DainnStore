package com.dainn.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dainn.dto.OrderDTO;
import com.dainn.dto.OrderDetailDTO;

public class OrderService_QT {

	private static Connection connection = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;

	public static List<OrderDTO> getOrder_QT() throws SQLException {
		List<OrderDTO> orders = new ArrayList<OrderDTO>();

		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT * FROM `order` Where status = 1";
			stmt = connection.prepareStatement(query);

			rs = stmt.executeQuery();
			while (rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setId(rs.getInt("id"));
				order.setCustomerId(rs.getInt("customer_id"));
				order.setAccountId(rs.getInt("account_id"));
				order.setCreatedDate(rs.getTimestamp("createddate"));
				order.setTotalPrice(rs.getInt("totalprice"));
				orders.add(order);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return orders;
	}

	public static List<OrderDTO> getFindOrder_QT(String find) throws SQLException {
		List<OrderDTO> orders = new ArrayList<OrderDTO>();

		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT * FROM `order` WHERE id = ? AND status = 1";

			stmt = connection.prepareStatement(query);
			stmt.setString(1, find);

			rs = stmt.executeQuery();
			while (rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setId(rs.getInt("id"));
				order.setCustomerId(rs.getInt("customer_id"));
				order.setAccountId(rs.getInt("account_id"));
				order.setCreatedDate(rs.getTimestamp("createddate"));
				order.setTotalPrice(rs.getInt("totalprice"));
				orders.add(order);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return orders;
	}

	public static List<OrderDTO> getFindOrderFromMonth_QT(int month) throws SQLException {
		List<OrderDTO> orders = new ArrayList<OrderDTO>();

		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT * FROM `order` WHERE MONTH(createddate) = ? AND status = 1";

			stmt = connection.prepareStatement(query);
			stmt.setInt(1, month);

			rs = stmt.executeQuery();
			while (rs.next()) {
				OrderDTO order = new OrderDTO();
				order.setId(rs.getInt("id"));
				order.setCustomerId(rs.getInt("customer_id"));
				order.setAccountId(rs.getInt("account_id"));
				order.setCreatedDate(rs.getTimestamp("createddate"));
				order.setTotalPrice(rs.getInt("totalprice"));
				orders.add(order);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return orders;
	}

	public static List<OrderDetailDTO> getOrderDetail_QT(int orderId) throws SQLException {
		OrderDetailDTO orderDetail = new OrderDetailDTO();
		List<OrderDetailDTO> list = new ArrayList<>();
		try {
			connection = DBService_QT.getConnection();
			String query = "SELECT * FROM `orderdetail` WHERE order_id = ?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, orderId);

			rs = stmt.executeQuery();
			while (rs.next()) {
				orderDetail.setOrderId(rs.getInt("order_id"));
				orderDetail.setProductId(rs.getInt("product_id"));
				orderDetail.setRomId(rs.getInt("rom_id"));
				orderDetail.setQuantity(rs.getInt("quantity"));
				orderDetail.setPrice(rs.getInt("price"));
				list.add(orderDetail);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
		return list;
	}

	public static void deleteOrder(Integer orderId) throws SQLException {
		try {
			connection = DBService_QT.getConnection();
			String query = "UPDATE `order` SET status = 0 WHERE id = ?";
			stmt = connection.prepareStatement(query);
			stmt.setInt(1, orderId);
			stmt.executeUpdate();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		} finally {
			DBService_QT.closeResourcesPreparedStatement(stmt, connection, rs);
		}
	}
}
