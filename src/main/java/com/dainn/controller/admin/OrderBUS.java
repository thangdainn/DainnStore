package com.dainn.controller.admin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dainn.dao.OrderDAL;
import com.dainn.dto.OrderDTO;
import com.dainn.dto.OrderDetailDTO;

public class OrderBUS {

	public static void loadOrder(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

		try {
			List<OrderDTO> Orders = OrderDAL.getOrder_QT();
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
			List<OrderDTO> orders = OrderDAL.getFindOrder_QT(find);
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
			List<OrderDTO> orders = OrderDAL.getFindOrderFromMonth_QT(month);
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
	
	public static void deleteOrder(JTable dataTable) {
		DefaultTableModel tableModel = (DefaultTableModel) dataTable.getModel();
		try {
			int row = dataTable.getSelectedRow();
			if (row != -1){
				int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa?", "Conform", JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					OrderDAL.deleteOrder((Integer) tableModel.getValueAt(row, 0));
					JOptionPane.showMessageDialog(null, "Xóa đơn hàng thành công.");
					loadOrder(dataTable);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Chọn hóa đơn để xóa!");
			}
		} catch (SQLException ex){
			JOptionPane.showMessageDialog(null, "Error!");
		}

	}

	public static void loadOrderDetail(JTable table, int orderId) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			tableModel.setRowCount(0);
			List<OrderDetailDTO> list = OrderDAL.getOrderDetail_QT(orderId);
			for (OrderDetailDTO dto : list){
				Object[] rowData = { dto.getOrderId(), dto.getProductId(), dto.getRomId(),
						dto.getQuantity(), dto.getPrice() };
				tableModel.addRow(rowData);
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}
}
