package com.dainn.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dainn.dto.CustomerDTO;
import com.dainn.service.CustomerService_QT;

public class CustomerController_QT {

	public static void loadCustomer(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			List<CustomerDTO> customers = CustomerService_QT.getCustomer_QT();
			tableModel.setRowCount(0);
			for (CustomerDTO customer : customers) {
				Object[] rowData = { customer.getId(), customer.getName(), customer.getAddress(), customer.getPhone(),
						customer.getPoints() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}

}
