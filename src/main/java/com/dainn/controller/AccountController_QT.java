package com.dainn.controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
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

}
