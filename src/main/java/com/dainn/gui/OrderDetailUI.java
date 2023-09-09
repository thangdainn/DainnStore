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

public class OrderDetailUI extends JFrame {

	private Integer orderId;
	private JPanel contentPane;
	public JTable table_orderDetail;
	private JTextField textField_detailId;
	private JTextField textField_detailCusId;
	private JTextField textField_detailName;
	private JTextField textField_detailPhone;
	private JTextField textField_detailDate;
	private JTextField textField_detailAddress;
	private JTextField textField_totalPrice;

	public OrderDetailUI(Integer orderId) {
		setTitle("Chi tiết đơn hàng");
		setResizable(false);
		this.init();
		this.orderId = orderId;
//		this.showDataOrderDetailToComponents();
//		this.showListOrderDetailToTable();
	}

	public void init() {
		setSize(1047, 618);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(84, 40, 132), null),
				"Th\u00F4ng tin \u0111\u1EB7t h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 79, 1013, 148);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn:");
		lblNewLabel_1.setFont(
				new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(59, 42, 96, 22);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_1_1.setFont(
				new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(59, 89, 96, 22);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tên khách hàng:");
		lblNewLabel_1_2.setFont(
				new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(369, 42, 96, 22);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Số điện thoại:");
		lblNewLabel_1_3.setFont(
				new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_3.setBounds(369, 89, 96, 22);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Ngày đặt hàng:");
		lblNewLabel_1_4.setFont(
				new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_4.setBounds(652, 42, 96, 22);
		panel.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("Địa chỉ:");
		lblNewLabel_1_5.setFont(
				new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_5.setBounds(652, 89, 96, 22);
		panel.add(lblNewLabel_1_5);

		textField_detailId = new JTextField();
		textField_detailId.setEditable(false);
		textField_detailId.setBounds(152, 44, 133, 19);
		panel.add(textField_detailId);
		textField_detailId.setColumns(10);

		textField_detailCusId = new JTextField();
		textField_detailCusId.setEditable(false);
		textField_detailCusId.setColumns(10);
		textField_detailCusId.setBounds(152, 91, 133, 19);
		panel.add(textField_detailCusId);

		textField_detailName = new JTextField();
		textField_detailName.setEditable(false);
		textField_detailName.setColumns(10);
		textField_detailName.setBounds(465, 44, 133, 19);
		panel.add(textField_detailName);

		textField_detailPhone = new JTextField();
		textField_detailPhone.setEditable(false);
		textField_detailPhone.setColumns(10);
		textField_detailPhone.setBounds(465, 91, 133, 19);
		panel.add(textField_detailPhone);

		textField_detailDate = new JTextField();
		textField_detailDate.setEditable(false);
		textField_detailDate.setColumns(10);
		textField_detailDate.setBounds(742, 44, 181, 19);
		panel.add(textField_detailDate);

		textField_detailAddress = new JTextField();
		textField_detailAddress.setEditable(false);
		textField_detailAddress.setColumns(10);
		textField_detailAddress.setBounds(742, 91, 181, 19);
		panel.add(textField_detailAddress);

		JLabel lblNewLabel = new JLabel("Chi tiết đơn hàng");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setFont(
				new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds(36, 10, 294, 59);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(84, 40, 132), null),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 228, 1013, 300);
		contentPane.add(scrollPane);

		table_orderDetail = new JTable();
		table_orderDetail.setRowHeight(24);
		table_orderDetail.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng",
						"\u0110\u01A1n gi\u00E1", "Th\u00E0nh ti\u1EC1n" }) {
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
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1_6.setBounds(847, 536, 59, 22);
		contentPane.add(lblNewLabel_1_6);

		textField_totalPrice = new JTextField();
		textField_totalPrice.setEditable(false);
		textField_totalPrice.setColumns(10);
		textField_totalPrice.setBounds(904, 538, 112, 19);
		contentPane.add(textField_totalPrice);

		this.setVisible(true);
	}

//	public void addRowOrderDetail(OrderDetail orderDetail) {
//		DefaultTableModel tableDetailModel = (DefaultTableModel) this.table_orderDetail.getModel();
//		tableDetailModel
//				.addRow(new Object[] { orderDetail.getProduct().getId() + "", orderDetail.getProduct().getName(),
//						orderDetail.getQuantity() + "",orderDetail.getProduct().getPrice() + "" , orderDetail.getPrice() + "" });
//	}
//
//	public void showListOrderDetailToTable() {
//		List<OrderDetail> orderDetails = OrderDetailDAO.getInstance().selectAllByOrderId(this.orderId);
//		for (OrderDetail orderDetail : orderDetails) {
//			this.addRowOrderDetail(orderDetail);
//		}
//	}
//
//	public void showDataOrderDetailToComponents() {
//		CustomerOrder order = CustomerOrderDAO.getInstance().selectById(this.orderId.toString());
//		this.textField_detailCusId.setText(order.getCustomer().getId() + "");
//		this.textField_detailName.setText(order.getName());
//		this.textField_detailPhone.setText(order.getPhone());
//		this.textField_detailDate.setText(order.getOrderDate() + "");
//		this.textField_detailAddress.setText(order.getAddress());
//		this.textField_totalPrice.setText(order.getTotalPrice() + "");
//	}
}
