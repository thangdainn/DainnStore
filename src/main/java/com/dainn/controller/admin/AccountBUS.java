package com.dainn.controller.admin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dainn.dao.AccountDAL;
import com.dainn.dto.AccountDTO;

public class AccountBUS {

	public static void loadAccount(JTable table) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

		try {
			List<AccountDTO> accounts = AccountDAL.getAccount_QT();
			tableModel.setRowCount(0);
			for (AccountDTO account : accounts) {
				Object[] rowData = { account.getId(), account.getUsername(), account.getPassword(), account.getRoleId(),
						account.getFullName(), account.getPhone() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void findAccount(JTable table, JTextField textFindAcc) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		String find = textFindAcc.getText();

		try {
			List<AccountDTO> accounts = AccountDAL.getFindAccount_QT(find);
			tableModel.setRowCount(0);
			for (AccountDTO account : accounts) {
				Object[] rowData = { account.getId(), account.getUsername(), account.getPassword(), account.getRoleId(),
						account.getFullName(), account.getPhone() };
				tableModel.addRow(rowData);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void loadFormAccount(JTable table_account, int selectedRow, JTextField txtIdAcc,
			JTextField txtUsernameAcc, JTextField txtPasswordAcc, JTextField txtFullNameAcc,
			JComboBox<String> cbbRoleAcc, JTextField txtPhoneAcc) {
		if (selectedRow >= 0) {
			int id = (int) table_account.getValueAt(selectedRow, 0);
			String username = (String) table_account.getValueAt(selectedRow, 1);
			String password = (String) table_account.getValueAt(selectedRow, 2);
			String role = (String) table_account.getValueAt(selectedRow, 3);
			String fullname = (String) table_account.getValueAt(selectedRow, 4);
			String phone = (String) table_account.getValueAt(selectedRow, 5);

			txtIdAcc.setText(String.valueOf(id));
			txtUsernameAcc.setText(username);
			txtPasswordAcc.setText(password);
			if (role.equals("ADMIN")) {
				cbbRoleAcc.setSelectedItem("ADMIN");
			} else {
				cbbRoleAcc.setSelectedItem("STAFF");
			}
			txtFullNameAcc.setText(fullname);
			txtPhoneAcc.setText(phone);
		}
	}

	public static void insertAccount(JTable table_account, JTextField txtIdAcc, JTextField txtUsernameAcc,
			JTextField txtPasswordAcc, JTextField txtFullNameAcc, JComboBox<String> cbbRoleAcc,
			JTextField txtPhoneAcc) {
		String username = txtUsernameAcc.getText();
		String password = txtPasswordAcc.getText();
		String fullname = txtFullNameAcc.getText();
		String role = (String) cbbRoleAcc.getSelectedItem();
		String phone = txtPhoneAcc.getText();

		if (txtIdAcc.getText().isEmpty()) {

			if (!username.isEmpty() && !password.isEmpty() && !fullname.isEmpty() && !phone.isEmpty()) {

				if (username.length() > 3 && password.length() > 3) {

					if (isNumeric(phone) && phone.length() == 10 && phone.startsWith("0")) {

						if (!AccountDAL.isNameExistsInsert(username)) {
							AccountDTO account = new AccountDTO();
							account.setUsername(username);
							account.setPassword(password);
							account.setFullName(fullname);
							account.setRoleId(role);
							account.setPhone(phone);

							try {
								AccountDAL.insertAccount(account);
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error",
										JOptionPane.ERROR_MESSAGE);
							}

							resetForm(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc, txtFullNameAcc,
									cbbRoleAcc, txtPhoneAcc);
						} else {
							JOptionPane.showMessageDialog(null, "Username đã tồn tại !");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Số điện thoạt không hợp lệ!");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Độ dài username và password phải > 3 ký tự!");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Dữ liệu rỗng !");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Không thể thực hiện chức năng này. Vui lòng Reload!");
		}
	}

	public static void updateAccount(JTable table_account, JTextField txtIdAcc, JTextField txtUsernameAcc,
			JTextField txtPasswordAcc, JTextField txtFullNameAcc, JComboBox<String> cbbRoleAcc,
			JTextField txtPhoneAcc) {
		String username = txtUsernameAcc.getText();
		String password = txtPasswordAcc.getText();
		String fullname = txtFullNameAcc.getText();
		String role = (String) cbbRoleAcc.getSelectedItem();
		String idd = txtIdAcc.getText();
		String phone = txtPhoneAcc.getText();

		if (!txtIdAcc.getText().isEmpty() && !txtUsernameAcc.getText().isEmpty() && !txtPasswordAcc.getText().isEmpty()
				&& !txtFullNameAcc.getText().isEmpty() && !txtPhoneAcc.getText().isEmpty()) {

			if (username.length() > 3 && password.length() > 3) {

				if (isNumeric(phone) && phone.length() == 10 && phone.startsWith("0")) {

					int id = Integer.parseInt(idd);
					if (!AccountDAL.isNameExistsUpdate(username, id)) {
						AccountDTO account = new AccountDTO();
						account.setId(id);
						account.setUsername(username);
						account.setPassword(password);
						account.setFullName(fullname);
						account.setRoleId(role);
						account.setPhone(phone);

						try {
							AccountDAL.updateAccount(account);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error",
									JOptionPane.ERROR_MESSAGE);
						}

						resetForm(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc, txtFullNameAcc, cbbRoleAcc,
								txtPhoneAcc);
					} else {
						JOptionPane.showMessageDialog(null, "Username đã tồn tại !");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Số điện thoạt không hợp lệ!");
				}

			} else {
				JOptionPane.showMessageDialog(null, "Độ dài username và password phải > 3 ký tự!");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Dữ liệu rỗng !");
		}
	}

	public static boolean isNumeric(String str) {
		return str.matches("\\d+");
	}

	public static void deleteAccount(JTable table_account, JTextField txtIdAcc, JTextField txtUsernameAcc,
			JTextField txtPasswordAcc, JTextField txtFullNameAcc, JComboBox<String> cbbRoleAcc,
			JTextField txtPhoneAcc) {

		if (!txtIdAcc.getText().isEmpty()) {
			int choice = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa tài khoản này?", "Confirmation",
					JOptionPane.YES_NO_OPTION);
			
			if (choice == JOptionPane.YES_OPTION) {
				int id = Integer.parseInt(txtIdAcc.getText());
				int status = 0;

				AccountDTO account = new AccountDTO();
				account.setId(id);
				account.setStatus(status);

				try {
					AccountDAL.deleteAccount(account);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error!: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}

				resetForm(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc, txtFullNameAcc, cbbRoleAcc,
						txtPhoneAcc);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Dữ liệu rỗng !");
		}
	}

	public static void resetForm(JTable table_account, JTextField txtIdAcc, JTextField txtUsernameAcc,
			JTextField txtPasswordAcc, JTextField txtFullNameAcc, JComboBox<String> cbbRoleAcc,
			JTextField txtPhoneAcc) {
		txtIdAcc.setText("");
		txtUsernameAcc.setText("");
		txtPasswordAcc.setText("");
		txtFullNameAcc.setText("");
		cbbRoleAcc.setSelectedIndex(0);
		txtPhoneAcc.setText("");
		loadAccount(table_account);
	}
}
