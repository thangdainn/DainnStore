package com.dainn.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
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
				Object[] rowData = { customer.getId(), customer.getName(), customer.getPhone(), customer.getAddress(),
						customer.getPoints() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}

	public static void loadFormCustomer(JTable table_customer, int selectedRow, JTextField txtidCustomer,
			JTextField txtnameCustomer, JTextField txtphoneCustomer, JTextField txtaddressCustomer,
			JTextField txtpointCustomer) {
		if (selectedRow >= 0) {
			int id = (int) table_customer.getValueAt(selectedRow, 0);
			String name = (String) table_customer.getValueAt(selectedRow, 1);
			String phone = (String) table_customer.getValueAt(selectedRow, 2);
			String address = (String) table_customer.getValueAt(selectedRow, 3);
			int point = (int) table_customer.getValueAt(selectedRow, 4);

			txtidCustomer.setText(String.valueOf(id));
			txtnameCustomer.setText(name);
			txtphoneCustomer.setText(phone);
			txtaddressCustomer.setText(address);
			txtpointCustomer.setText(String.valueOf(point));
		}
	}

	public static void updateCustomer(JTable dataTable, JTextField idField, JTextField nameField,
			JTextField addressField, JTextField phoneField, JTextField pointField) {
		int id = Integer.parseInt(idField.getText());
		String name = nameField.getText();
		String address = addressField.getText();
		String phone = phoneField.getText();
		int point = Integer.parseInt(pointField.getText());

		CustomerDTO customer = new CustomerDTO();
		customer.setId(id);
		customer.setName(name);
		customer.setAddress(address);
		customer.setPhone(phone);
		customer.setPoints(point);

		try {
			CustomerService_QT.updateCustomer(customer);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		resetForm(dataTable, idField, nameField, addressField, phoneField, pointField);
	}

	public static void deleteCustomer(JTable dataTable, JTextField idField, JTextField nameField,
			JTextField addressField, JTextField phoneField, JTextField pointField) {
		int id = Integer.parseInt(idField.getText());
		int status = 0;

		CustomerDTO customer = new CustomerDTO();
		customer.setId(id);
		customer.setStatus(status);

		try {
			CustomerService_QT.deleteCustomer(customer);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		resetForm(dataTable, idField, nameField, addressField, phoneField, pointField);
	}

	public static void resetForm(JTable dataTable, JTextField idField, JTextField nameField, JTextField addressField,
			JTextField phoneField, JTextField pointField) {
		idField.setText("");
		nameField.setText("");
		addressField.setText("");
		phoneField.setText("");
		pointField.setText("");
		loadCustomer(dataTable);
	}
}
