package com.dainn.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.dainn.controller.admin.OrderBUS;

import javax.swing.SwingConstants;

public class OrderDetailUI extends JFrame {
	private static final long serialVersionUID = 1L;

	public JPanel contentPane;
	public JTable table_orderDetail;
	public JTextField textField_totalPrice;

	public OrderDetailUI(Integer orderId, Integer totalPrice) {
		this.init(orderId, totalPrice);
		setTitle("Chi tiết đơn hàng");
		setResizable(false);
	}

	@SuppressWarnings("serial")
	public void init(int orderId, int totalPrice) {
		setSize(1047, 618);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chi tiết đơn hàng");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds(36, 10, 294, 59);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(84, 40, 132), null),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 79, 1013, 449);
		contentPane.add(scrollPane);

		table_orderDetail = new JTable();
		table_orderDetail.setRowHeight(24);
		table_orderDetail.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Mã hóa đơn", "Mã sản phẩm", "Mã ROM", "Số lượng", "Đơn giá" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_orderDetail.getColumnModel().getColumn(0).setResizable(false);
		table_orderDetail.getColumnModel().getColumn(1).setResizable(false);
		table_orderDetail.getColumnModel().getColumn(2).setResizable(false);
		table_orderDetail.getColumnModel().getColumn(3).setResizable(false);
		table_orderDetail.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(table_orderDetail);

		JLabel lblNewLabel_1_6 = new JLabel("Tổng tiền:");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(847, 536, 59, 22);
		contentPane.add(lblNewLabel_1_6);

		textField_totalPrice = new JTextField();
		textField_totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_totalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_totalPrice.setText("0đ");
		textField_totalPrice.setEditable(false);
		textField_totalPrice.setColumns(10);
		textField_totalPrice.setBounds(904, 538, 112, 19);
		contentPane.add(textField_totalPrice);

		this.setVisible(true);

		// QT
		textField_totalPrice.setText(String.valueOf(totalPrice));
		OrderBUS.loadOrderDetail(table_orderDetail, orderId);
	}
}
