package com.dainn.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dainn.dto.Account_QT;
import com.dainn.service.AccountService_QT;

public class AccountController_QT {

	public static void loadAccount(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		try {
			List<Account_QT> accounts = AccountService_QT.getAccount_QT();
			tableModel.setRowCount(0);
			for (Account_QT account : accounts) {
				Object[] rowData = { account.getId(), account.getUsername(), account.getPassword(), account.getRoleId(),
						account.getFullName() };
				tableModel.addRow(rowData);
			}
			JOptionPane.showMessageDialog(null, "Success!");
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!");
		}
	}

}
