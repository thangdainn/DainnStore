package com.dainn.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dainn.dto.AccountDTO;
import com.dainn.service.AccountService_QT;

public class AccountController_QT {

	public static void loadAccount(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			List<AccountDTO> accounts = AccountService_QT.getAccount_QT();
			tableModel.setRowCount(0);
			for (AccountDTO account : accounts) {
				Object[] rowData = { account.getId(), account.getUsername(), account.getPassword(), account.getRoleId(),
						account.getFullName() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}

	public static void loadFormAccount(JTable table_account, int selectedRow, JTextField txtIdAcc,
			JTextField txtUsernameAcc, JTextField txtPasswordAcc, JTextField txtFullNameAcc,
			JComboBox<String> cbbRoleAcc) {
		if (selectedRow >= 0) {
			int id = (int) table_account.getValueAt(selectedRow, 0);
			String username = (String) table_account.getValueAt(selectedRow, 1);
			String password = (String) table_account.getValueAt(selectedRow, 2);
			String role = (String) table_account.getValueAt(selectedRow, 3);
			String fullname = (String) table_account.getValueAt(selectedRow, 4);

			txtIdAcc.setText(String.valueOf(id));
			txtUsernameAcc.setText(username);
			txtPasswordAcc.setText(password);
			if (role.equals("ADMIN")) {
				cbbRoleAcc.setSelectedItem("Admin");
			} else {
				cbbRoleAcc.setSelectedItem("User");
			}
			txtFullNameAcc.setText(fullname);
		}
	}
}
