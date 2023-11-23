package com.dainn.gui;

import com.dainn.dto.ReceiptDetailDTO;
import com.dainn.service.IProductService;
import com.dainn.service.IReceiptDetailService;
import com.dainn.service.IRomService;
import com.dainn.service.impl.ProductService;
import com.dainn.service.impl.ReceiptDetailService;
import com.dainn.service.impl.RomService;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

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
import javax.swing.SwingConstants;

public class ReceiptDetailUI extends JFrame {

	private JPanel contentPane;
	public JTable table_receiptDetail;
	private JTextField textField_totalPrice;
	private IReceiptDetailService receiptDetailService = new ReceiptDetailService();
	private IProductService productService = new ProductService();
	private IRomService romService = new RomService();

	public ReceiptDetailUI(Integer receiptId) {
		setTitle("Chi tiết đơn hàng");
		setResizable(false);
		this.init();
		showDataToTable(receiptDetailService.findByReceipt_Id(receiptId));
	}

	public void init() {
		setSize(1047, 618);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chi tiết phiếu nhập");
		lblNewLabel.setForeground(new Color(128, 0, 255));
		lblNewLabel.setFont(
				new Font("Times New Roman", Font.BOLD, 36));
		lblNewLabel.setBounds(36, 10, 294, 59);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(84, 40, 132), null),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setBounds(10, 90, 1013, 438);
		contentPane.add(scrollPane);

		table_receiptDetail = new JTable();
		table_receiptDetail.setRowHeight(24);
		table_receiptDetail.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Dung l\u01B0\u1EE3ng", "Gi\u00E1 nh\u1EADp", "Th\u00E0nh ti\u1EC1n"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_receiptDetail.getColumnModel().getColumn(0).setResizable(false);
		table_receiptDetail.getColumnModel().getColumn(1).setResizable(false);
		table_receiptDetail.getColumnModel().getColumn(2).setResizable(false);
		table_receiptDetail.getColumnModel().getColumn(3).setResizable(false);
		table_receiptDetail.getColumnModel().getColumn(4).setResizable(false);
		table_receiptDetail.getColumnModel().getColumn(5).setResizable(false);
		scrollPane.setViewportView(table_receiptDetail);

		JLabel lblNewLabel_1_6 = new JLabel("Tổng tiền:");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1_6.setBounds(845, 538, 59, 22);
		contentPane.add(lblNewLabel_1_6);

		textField_totalPrice = new JTextField();
		textField_totalPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textField_totalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_totalPrice.setText("0đ");
		textField_totalPrice.setEditable(false);
		textField_totalPrice.setColumns(10);
		textField_totalPrice.setBounds(904, 538, 112, 19);
		contentPane.add(textField_totalPrice);

		this.setVisible(true);
	}

	private void showDataToTable(List<ReceiptDetailDTO> list){
		DefaultTableModel tableModel = (DefaultTableModel) table_receiptDetail.getModel();
		long sum = 0;
		if (list != null){
			for (ReceiptDetailDTO item : list){
				tableModel.addRow(new Object[]{
						item.getProductId(),
						productService.findById(item.getProductId()).getName(),
						item.getQuantity(),
						item.getRomId() == 6 ? "Không có" : romService.findById(item.getRomId()).getCapacity(),
						item.getImportPrice(),
						item.getAmount()
				});
				sum += item.getAmount();
			}
			textField_totalPrice.setText(sum + "đ");
		}
	}
}
