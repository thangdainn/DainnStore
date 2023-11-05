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
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
				cbbRoleAcc.setSelectedItem("ADMIN");
			} else {
				cbbRoleAcc.setSelectedItem("STAFF");
			}
			txtFullNameAcc.setText(fullname);
		}
	}

	public static void updateAccount(JTable table_account, JTextField txtIdAcc, JTextField txtUsernameAcc,
			JTextField txtPasswordAcc, JTextField txtFullNameAcc, JComboBox<String> cbbRoleAcc) {
		int id = Integer.parseInt(txtIdAcc.getText());
		String username = txtUsernameAcc.getText();
		String password = txtPasswordAcc.getText();
		String fullname = txtFullNameAcc.getText();
		String role = (String) cbbRoleAcc.getSelectedItem();

		AccountDTO account = new AccountDTO();
		account.setId(id);
		account.setUsername(username);
		account.setPassword(password);
		account.setFullName(fullname);
		account.setRoleId(role);

		try {
			AccountService_QT.updateAccount(account);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		resetForm(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc, txtFullNameAcc, cbbRoleAcc);
	}

	public static void deleteAccount(JTable table_account, JTextField txtIdAcc, JTextField txtUsernameAcc,
			JTextField txtPasswordAcc, JTextField txtFullNameAcc, JComboBox<String> cbbRoleAcc) {
		int id = Integer.parseInt(txtIdAcc.getText());
		int status = 0;

		AccountDTO account = new AccountDTO();
		account.setId(id);
		account.setStatus(status);

		try {
			AccountService_QT.deleteAccount(account);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		resetForm(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc, txtFullNameAcc, cbbRoleAcc);
	}

	public static void resetForm(JTable table_account, JTextField txtIdAcc, JTextField txtUsernameAcc,
			JTextField txtPasswordAcc, JTextField txtFullNameAcc, JComboBox<String> cbbRoleAcc) {
		txtIdAcc.setText("");
		txtUsernameAcc.setText("");
		txtPasswordAcc.setText("");
		txtFullNameAcc.setText("");
		cbbRoleAcc.setSelectedIndex(0);
		loadAccount(table_account);
	}
}
