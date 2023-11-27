package com.dainn.controller.admin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dainn.dao.OrderService_QT;
import com.dainn.dto.OrderDTO;
import com.dainn.dto.OrderDetailDTO;

public class OrderController_QT {

	public static void loadOrder(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

		try {
			List<OrderDTO> Orders = OrderService_QT.getOrder_QT();
			tableModel.setRowCount(0);
			for (OrderDTO Order : Orders) {
				Object[] rowData = { Order.getId(), Order.getCustomerId(), Order.getAccountId(), Order.getCreatedDate(),
						Order.getTotalPrice() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}

	public static void findOrder(JTable table, JTextField findField) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String find = findField.getText();

		try {
			List<OrderDTO> orders = OrderService_QT.getFindOrder_QT(find);
			tableModel.setRowCount(0);
			for (OrderDTO order : orders) {
				Object[] rowData = { order.getId(), order.getCustomerId(), order.getAccountId(), order.getCreatedDate(),
						order.getTotalPrice() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void findOrderFromMonth(JTable table, int month) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			List<OrderDTO> orders = OrderService_QT.getFindOrderFromMonth_QT(month);
			tableModel.setRowCount(0);
			for (OrderDTO order : orders) {
				Object[] rowData = { order.getId(), order.getCustomerId(), order.getAccountId(), order.getCreatedDate(),
						order.getTotalPrice() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void resetForm(JTable dataTable, JTextField findField) {
		findField.setText("");
		loadOrder(dataTable);
	}

	public static void loadOrderDetail(JTable table, int orderId) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			tableModel.setRowCount(0);
			OrderDetailDTO OrderDetail = OrderService_QT.getOrderDetail_QT(orderId);
			Object[] rowData = { OrderDetail.getOrderId(), OrderDetail.getProductId(), OrderDetail.getRomId(),
					OrderDetail.getQuantity(), OrderDetail.getPrice() };
			tableModel.addRow(rowData);
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}
}
