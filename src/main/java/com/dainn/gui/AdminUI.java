package com.dainn.gui;

import com.dainn.controller.AccountController_QT;
import com.dainn.controller.admin.AdminHomeController;
import com.dainn.dto.AccountDTO;
import com.dainn.utils.NumberTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminUI extends JFrame {

	public AccountDTO accountDTO;
	public String imgPath;
	public JPanel contentPane;
	public JPanel btn_cusList;
	public JPanel btn_orderList;
	public JPanel btn_accList;
	public JPanel btn_productList;
	public JPanel currentJPanel;
	public JPanel panel_cards;
	public JTextField textfiel_proFind;
	public JTextField textField_proId;
	public JTextField textField_proName;
	public JTextField textField_proQuantity;
	public JTextField textField_proPrice;
	public JTable table_product;
	public JTextField textField_orderFind;
	public JTextField textField_cusId;
	public JTextField textField_cusName;
	public JTextField textField_cusPhone;
	public JTextField textField_cusAddress;
	public JTextField textField_cusFind;
	public JTextField textField_accFind;
	public JTable table_order;
	public JTable table_customer;
	public JTextField textField_accId;
	public JTextField textField_accPassword;
	public JTextField textField_accUsername;
	public JTable table_account;
	public JTextField textField_accCusId;
	public JLabel lbl_header;
	public JComboBox comboBox_accAccessId;
	public JLabel lbl_image;
	public JComboBox comboBox_prodCateId;
	public JComboBox comboBox_cusSex;
	public JButton btn_orderFind;
	public JComboBox comboBox_orderMonth;
	public JComboBox comboBox_orderStatus;
	public JTextField textField_receiptFind;
	public JTextField textField_receiptId;
	public JTextField textField_receiptTotalPrice;
	public JTextField textField_receiptDate;
	public JTable table_receipt;
	public JTextField textField_receiptQuantity;
	public JTable table_receiptProd;
	private JTextField textField_receiptAccId;
	private JTextField textField_receiptPrice;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_2;
	private JTable table_category;

	public AdminUI(AccountDTO account) {
		this.init();
		this.accountDTO = account;
//		this.showListProductToTable(this.products);
//		this.showListAccToTable(this.access.getAccounts());
	}

	public void init() {
		setTitle("Trang quản trị");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1097, 657);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		AdminHomeController adminHomeController = new AdminHomeController(this);
//		AdminProductController adminProductController = new AdminProductController(this);
//		AdminOrderController adminOrderController = new AdminOrderController(this);
//		AdminCusController adminCusController = new AdminCusController(this);
//		AdminAccController adminAccController = new AdminAccController(this);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(84, 40, 132));
		panel.setBounds(0, 0, 242, 620);
		contentPane.add(panel);
		panel.setLayout(null);

		btn_productList = new JPanel();
		btn_productList.setForeground(new Color(0, 0, 0));
		btn_productList.addMouseListener(adminHomeController);
		btn_productList.setName("productList");
		btn_productList.setBackground(new Color(123, 54, 199));
		btn_productList.setBounds(0, 170, 242, 47);
		panel.add(btn_productList);
		btn_productList.setLayout(null);
		currentJPanel = btn_productList;

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setIcon(
				new ImageIcon(AdminUI.class.getResource("/icons/icons8_products.png")));
		lblNewLabel.setBounds(10, 3, 40, 40);
		btn_productList.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Quản lý sản phẩm");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 16));
		lblNewLabel_1.setBackground(new Color(143, 88, 199));
		lblNewLabel_1.setBounds(65, 3, 167, 40);
		btn_productList.add(lblNewLabel_1);

		btn_cusList = new JPanel();
		btn_cusList.addMouseListener(adminHomeController);
		btn_cusList.setName("cusList");
		btn_cusList.setLayout(null);
		btn_cusList.setBackground(new Color(84, 40, 132));
		btn_cusList.setBounds(0, 284, 242, 47);
		panel.add(btn_cusList);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(
				new ImageIcon(AdminUI.class.getResource("/icons/icons8-customer-38.png")));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 3, 40, 40);
		btn_cusList.add(lblNewLabel_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Quản lý khách hàng");
		lblNewLabel_1_2_1.setFont(new Font("Arial", lblNewLabel_1_2_1.getFont().getStyle() | Font.BOLD, lblNewLabel_1_2_1.getFont().getSize() + 6));
		lblNewLabel_1_2_1.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_2_1.setBounds(65, 3, 167, 40);
		btn_cusList.add(lblNewLabel_1_2_1);

		btn_orderList = new JPanel();
		btn_orderList.addMouseListener(adminHomeController);
		btn_orderList.setName("orderList");
		btn_orderList.setLayout(null);
		btn_orderList.setBackground(new Color(84, 40, 132));
		btn_orderList.setBounds(0, 227, 242, 47);
		panel.add(btn_orderList);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-order-38.png")));
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 3, 40, 40);
		btn_orderList.add(lblNewLabel_3);

		JLabel lblNewLabel_1_2 = new JLabel("Quản lý đơn hàng");
		lblNewLabel_1_2.setFont(new Font("Arial", lblNewLabel_1_2.getFont().getStyle() | Font.BOLD, lblNewLabel_1_2.getFont().getSize() + 6));
		lblNewLabel_1_2.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_2.setBounds(65, 3, 167, 40);
		btn_orderList.add(lblNewLabel_1_2);

		btn_accList = new JPanel();
		btn_accList.addMouseListener(adminHomeController);
		btn_accList.setName("accList");
		btn_accList.setLayout(null);
		btn_accList.setBackground(new Color(84, 40, 132));
		btn_accList.setBounds(0, 341, 242, 47);
		panel.add(btn_accList);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(
				new ImageIcon(AdminUI.class.getResource("/icons/icons8-male-user-38.png")));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 3, 40, 40);
		btn_accList.add(lblNewLabel_4);

		JLabel lblNewLabel_1_2_2 = new JLabel("Quản lý tài khoản");
		lblNewLabel_1_2_2.setFont(new Font("Arial", lblNewLabel_1_2_2.getFont().getStyle() | Font.BOLD, lblNewLabel_1_2_2.getFont().getSize() + 6));
		lblNewLabel_1_2_2.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_2_2.setBounds(65, 3, 167, 40);
		btn_accList.add(lblNewLabel_1_2_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 98, 174, 15);
		panel.add(separator);

		JLabel lblNewLabel_5 = new JLabel("Dainn Store");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblNewLabel_5.setBounds(10, 41, 186, 47);
		panel.add(lblNewLabel_5);
		
		JPanel btn_receipt = new JPanel();
		btn_receipt.addMouseListener(adminHomeController);
		btn_receipt.setLayout(null);
		btn_receipt.setName("receipt");
		btn_receipt.setForeground(Color.BLACK);
		btn_receipt.setBackground(new Color(84, 40, 132));
		btn_receipt.setBounds(0, 398, 242, 47);
		panel.add(btn_receipt);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-supplier-38.png")));
		lblNewLabel_6.setBackground(Color.WHITE);
		lblNewLabel_6.setBounds(10, 3, 40, 40);
		btn_receipt.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quản lý nhập hàng");
		lblNewLabel_1_1.setFont(new Font("Arial", lblNewLabel_1_1.getFont().getStyle() | Font.BOLD, lblNewLabel_1_1.getFont().getSize() + 6));
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1.setBounds(65, 3, 167, 40);
		btn_receipt.add(lblNewLabel_1_1);
		
		JPanel panel_logOut = new JPanel();
		panel_logOut.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_logOut.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new LoginUI();
            }
		});
		panel_logOut.setBackground(new Color(84, 40, 132));
		panel_logOut.setBounds(10, 565, 45, 45);
		panel.add(panel_logOut);
		panel_logOut.setLayout(null);
		
		JLabel lbl_logOut = new JLabel("");
		lbl_logOut.setBackground(new Color(84, 40, 132));
		lbl_logOut.setBounds(0, 0, 45, 45);
		panel_logOut.add(lbl_logOut);
		lbl_logOut.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-log-out-43.png")));
		
		JPanel btn_category = new JPanel();
		btn_category.addMouseListener(adminHomeController);
		btn_category.setLayout(null);
		btn_category.setName("category");
		btn_category.setForeground(Color.BLACK);
		btn_category.setBackground(new Color(84, 40, 132));
		btn_category.setBounds(0, 455, 242, 47);
		panel.add(btn_category);
		
		JLabel lblNewLabel_6_1 = new JLabel("");
		lblNewLabel_6_1.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-category-38.png")));
		lblNewLabel_6_1.setBackground(Color.WHITE);
		lblNewLabel_6_1.setBounds(10, 3, 40, 40);
		btn_category.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Quản lý loại hàng");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1.setBounds(66, 3, 167, 40);
		btn_category.add(lblNewLabel_1_1_1);
		
		JPanel btn_analytics = new JPanel();
		btn_analytics.addMouseListener(adminHomeController);
		btn_analytics.setLayout(null);
		btn_analytics.setName("analytics");
		btn_analytics.setForeground(Color.BLACK);
		btn_analytics.setBackground(new Color(84, 40, 132));
		btn_analytics.setBounds(0, 508, 242, 47);
		panel.add(btn_analytics);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("");
		lblNewLabel_6_1_1.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-analytics-38.png")));
		lblNewLabel_6_1_1.setBackground(Color.WHITE);
		lblNewLabel_6_1_1.setBounds(10, 3, 40, 40);
		btn_analytics.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Thống kê");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1.setBounds(66, 3, 167, 40);
		btn_analytics.add(lblNewLabel_1_1_1_1);

		panel_cards = new JPanel();
		panel_cards.setBounds(241, 70, 842, 550);
		contentPane.add(panel_cards);
		panel_cards.setLayout(new CardLayout(0, 0));

		JPanel panel_productList = new JPanel();
		panel_productList.setBackground(new Color(255, 255, 255));
		panel_cards.add(panel_productList, "panel_productList");
		panel_productList.setLayout(null);

		JPanel product_infor = new JPanel();
		product_infor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Th\u00F4ng tin s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		product_infor.setBounds(0, 50, 842, 157);
		panel_productList.add(product_infor);
		product_infor.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Mã sản phẩm:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9.setBounds(53, 29, 91, 13);
		product_infor.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_9_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1.setBounds(53, 71, 91, 13);
		product_infor.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_2 = new JLabel("Số lượng:");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2.setBounds(53, 113, 91, 13);
		product_infor.add(lblNewLabel_9_2);

		textField_proId = new JTextField();
		textField_proId.setEditable(false);
		textField_proId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_proId.setBounds(140, 27, 145, 19);
		product_infor.add(textField_proId);
		textField_proId.setColumns(10);

		textField_proName = new JTextField();
		textField_proName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_proName.setColumns(10);
		textField_proName.setBounds(140, 69, 145, 19);
		product_infor.add(textField_proName);

		textField_proQuantity = new JTextField();
		NumberTextField.numberTextField(textField_proQuantity);
		textField_proQuantity.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_proQuantity.setColumns(10);
		textField_proQuantity.setBounds(140, 111, 145, 19);
		product_infor.add(textField_proQuantity);

		JLabel lblNewLabel_9_1_1 = new JLabel("Loại sản phẩm:");
		lblNewLabel_9_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_1.setBounds(334, 71, 84, 13);
		product_infor.add(lblNewLabel_9_1_1);

		JLabel lblNewLabel_9_3 = new JLabel("Đơn giá:");
		lblNewLabel_9_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3.setBounds(334, 29, 75, 13);
		product_infor.add(lblNewLabel_9_3);

		textField_proPrice = new JTextField();
		NumberTextField.numberTextField(textField_proPrice);
		textField_proPrice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_proPrice.setColumns(10);
		textField_proPrice.setBounds(428, 26, 145, 19);
		product_infor.add(textField_proPrice);

		JLabel lblNewLabel_9_3_1 = new JLabel("Hình ảnh:");
		lblNewLabel_9_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_1.setBounds(607, 58, 75, 13);
		product_infor.add(lblNewLabel_9_3_1);

		JButton btn_proSelectImg = new JButton("Chọn ảnh");
		btn_proSelectImg.setFont(new Font("Tahoma", Font.PLAIN, 10));
//		btn_proSelectImg.addActionListener(adminProductController);
		btn_proSelectImg.setBackground(new Color(149, 92, 211));
		btn_proSelectImg.setBounds(607, 80, 75, 21);
		product_infor.add(btn_proSelectImg);

		lbl_image = new JLabel("");
		lbl_image.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(128, 128, 128), null));
		lbl_image.setBounds(687, 12, 133, 133);
		product_infor.add(lbl_image);
		
		comboBox_prodCateId = new JComboBox();
		comboBox_prodCateId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_prodCateId.addItem("Chọn loại sản phẩm");
		comboBox_prodCateId.addItem("iPhone");
		comboBox_prodCateId.addItem("iPad");
		comboBox_prodCateId.addItem("MacBook");
		comboBox_prodCateId.addItem("Apple Watch");
		comboBox_prodCateId.addItem("AirPods");
		comboBox_prodCateId.setBounds(428, 68, 145, 19);
		product_infor.add(comboBox_prodCateId);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Danh s\u00E1ch s\u1EA3n ph\u1EA9m", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(0, 206, 842, 294);
		panel_productList.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		scrollPane.setBounds(10, 20, 822, 264);
		panel_3.add(scrollPane);

		table_product = new JTable();
//		table_product.addMouseListener(adminProductController);
//		table_product.addKeyListener(adminProductController);
		table_product.setRowHeight(24);
		table_product.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng", "M\u00E3 lo\u1EA1i s\u1EA3n ph\u1EA9m", "M\u00E3 nh\u00E0 cung c\u1EA5p", "Image"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_product.getColumnModel().getColumn(0).setResizable(false);
		table_product.getColumnModel().getColumn(0).setPreferredWidth(81);
		table_product.getColumnModel().getColumn(1).setResizable(false);
		table_product.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_product.getColumnModel().getColumn(2).setResizable(false);
		table_product.getColumnModel().getColumn(3).setResizable(false);
		table_product.getColumnModel().getColumn(3).setPreferredWidth(57);
		table_product.getColumnModel().getColumn(4).setResizable(false);
		table_product.getColumnModel().getColumn(4).setPreferredWidth(92);
		table_product.getColumnModel().getColumn(5).setResizable(false);
		table_product.getColumnModel().getColumn(5).setPreferredWidth(92);
		table_product.getColumnModel().getColumn(6).setResizable(false);
		table_product.getColumnModel().getColumn(6).setPreferredWidth(200);
		table_product.getColumnModel().getColumn(6).setMinWidth(200);
		scrollPane.setViewportView(table_product);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 499, 842, 51);
		panel_productList.add(panel_4);
		panel_4.setLayout(null);

		JButton btn_addProduct = new JButton("Thêm");
//		btn_addProduct.addActionListener(adminProductController);
		btn_addProduct.setBackground(new Color(149, 92, 211));
		btn_addProduct.setBounds(188, 15, 85, 21);
		panel_4.add(btn_addProduct);

		JButton btn_updateProduct = new JButton("Lưu");
//		btn_updateProduct.addActionListener(adminProductController);
		btn_updateProduct.setBackground(new Color(149, 92, 211));
		btn_updateProduct.setBounds(283, 15, 85, 21);
		panel_4.add(btn_updateProduct);

		JButton btn_deleteProduct = new JButton("Xóa");
//		btn_deleteProduct.addActionListener(adminProductController);
		btn_deleteProduct.setBackground(new Color(149, 92, 211));
		btn_deleteProduct.setBounds(378, 15, 85, 21);
		panel_4.add(btn_deleteProduct);

		JButton btn_deleteAllProduct = new JButton("Xóa tất cả");
//		btn_deleteAllProduct.addActionListener(adminProductController);
		btn_deleteAllProduct.setBackground(new Color(149, 92, 211));
		btn_deleteAllProduct.setBounds(473, 15, 85, 21);
		panel_4.add(btn_deleteAllProduct);

		JButton btn_resetProduct = new JButton("Làm mới");
//		btn_resetProduct.addActionListener(adminProductController);
		btn_resetProduct.setBackground(new Color(149, 92, 211));
		btn_resetProduct.setBounds(568, 15, 85, 21);
		panel_4.add(btn_resetProduct);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(0, 0, 842, 51);
		panel_productList.add(panel_5);
		panel_5.setLayout(null);

		textfiel_proFind = new JTextField();
//		textfiel_proFind.addFocusListener(adminProductController);
		textfiel_proFind.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textfiel_proFind.setBackground(new Color(255, 255, 255));
		textfiel_proFind.setBounds(98, 16, 347, 19);
		panel_5.add(textfiel_proFind);
		textfiel_proFind.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Tìm kiếm");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8.setBounds(43, 19, 45, 13);
		panel_5.add(lblNewLabel_8);

		JButton btn_proFind = new JButton("Tìm");
		btn_proFind.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		btn_proFind.addActionListener(adminProductController);
		btn_proFind.setBackground(new Color(149, 92, 211));
		btn_proFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_proFind.setBounds(455, 15, 85, 21);
		panel_5.add(btn_proFind);

		JPanel panel_orderList = new JPanel();
		panel_orderList.setLayout(null);
		panel_orderList.setBackground(Color.WHITE);
		panel_cards.add(panel_orderList, "panel_orderList");

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Danh s\u00E1ch \u0111\u01A1n h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3_1.setBounds(0, 49, 842, 451);
		panel_orderList.add(panel_3_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		scrollPane_1.setBounds(10, 21, 822, 420);
		panel_3_1.add(scrollPane_1);

		table_order = new JTable();
//		table_order.addMouseListener(adminOrderController);
		table_order.setRowHeight(24);
		table_order.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u01A1n h\u00E0ng", "M\u00E3 kh\u00E1ch h\u00E0ng", "Ng\u00E0y \u0111\u1EB7t h\u00E0ng", "T\u1ED5ng ti\u1EC1n", "Tr\u1EA1ng th\u00E1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_order.getColumnModel().getColumn(0).setResizable(false);
		table_order.getColumnModel().getColumn(1).setResizable(false);
		table_order.getColumnModel().getColumn(2).setResizable(false);
		table_order.getColumnModel().getColumn(3).setResizable(false);
		table_order.getColumnModel().getColumn(4).setResizable(false);
		scrollPane_1.setViewportView(table_order);

		JPanel panel_ = new JPanel();
		panel_.setLayout(null);
		panel_.setBounds(0, 499, 842, 51);
		panel_orderList.add(panel_);

		JButton btn_confirmOrder = new JButton("Xác nhận");
//		btn_confirmOrder.addActionListener(adminOrderController);
		btn_confirmOrder.setBackground(new Color(149, 92, 211));
		btn_confirmOrder.setBounds(283, 15, 85, 21);
		panel_.add(btn_confirmOrder);

		JButton btn_cancelOrder = new JButton("Hủy");
//		btn_cancelOrder.addActionListener(adminOrderController);
		btn_cancelOrder.setBackground(new Color(149, 92, 211));
		btn_cancelOrder.setBounds(378, 15, 85, 21);
		panel_.add(btn_cancelOrder);

		JButton btn_resetOrder = new JButton("Làm mới");
//		btn_resetOrder.addActionListener(adminOrderController);
		btn_resetOrder.setBackground(new Color(149, 92, 211));
		btn_resetOrder.setBounds(473, 15, 85, 21);
		panel_.add(btn_resetOrder);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_1.setBounds(0, 0, 842, 51);
		panel_orderList.add(panel_5_1);

		textField_orderFind = new JTextField();
//		textField_orderFind.addFocusListener(adminOrderController);
		textField_orderFind.setColumns(10);
		textField_orderFind.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_orderFind.setBackground(Color.WHITE);
		textField_orderFind.setBounds(98, 16, 347, 19);
		panel_5_1.add(textField_orderFind);

		JLabel lblNewLabel_8_1 = new JLabel("Tìm kiếm");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_1.setBounds(43, 19, 45, 13);
		panel_5_1.add(lblNewLabel_8_1);

		btn_orderFind = new JButton("Tìm");
		btn_orderFind.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		btn_orderFind.addActionListener(adminOrderController);
		btn_orderFind.setBackground(new Color(149, 92, 211));
		btn_orderFind.setBounds(455, 15, 85, 21);
		panel_5_1.add(btn_orderFind);

		comboBox_orderMonth = new JComboBox();
		comboBox_orderMonth.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		comboBox_orderMonth.addActionListener(adminOrderController);
//		comboBox_orderMonth.addActionListener(adminOrderController);
		comboBox_orderMonth.addItem("Tháng đặt hàng");
		for (int i = 1; i <= 12; i++) {
			comboBox_orderMonth.addItem("Tháng " + i);
		}
		comboBox_orderMonth.setBounds(586, 15, 114, 20);
		panel_5_1.add(comboBox_orderMonth);

		comboBox_orderStatus = new JComboBox();
		comboBox_orderStatus.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		comboBox_orderStatus.addActionListener(adminOrderController);
//		comboBox_orderStatus.addActionListener(adminOrderController);
		comboBox_orderStatus.addItem("Trạng thái");
		comboBox_orderStatus.addItem("Đang xử lý");
		comboBox_orderStatus.addItem("Đã xử lý");
		comboBox_orderStatus.addItem("Đã hủy");
		comboBox_orderStatus.setBounds(710, 15, 85, 20);
		panel_5_1.add(comboBox_orderStatus);

		JPanel panel_cusList = new JPanel();
		panel_cusList.setLayout(null);
		panel_cusList.setBackground(Color.WHITE);
		panel_cards.add(panel_cusList, "panel_cusList");

		JPanel cus_infor = new JPanel();
		cus_infor.setLayout(null);
		cus_infor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		cus_infor.setBounds(0, 50, 842, 123);
		panel_cusList.add(cus_infor);

		JLabel lblNewLabel_9_5 = new JLabel("Mã khách hàng:");
		lblNewLabel_9_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_5.setBounds(66, 32, 91, 13);
		cus_infor.add(lblNewLabel_9_5);

		JLabel lblNewLabel_9_1_3 = new JLabel("Tên khách hàng:");
		lblNewLabel_9_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_3.setBounds(66, 77, 91, 13);
		cus_infor.add(lblNewLabel_9_1_3);

		textField_cusId = new JTextField();
		textField_cusId.setEditable(false);
		textField_cusId.setColumns(10);
		textField_cusId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cusId.setBounds(167, 30, 124, 19);
		cus_infor.add(textField_cusId);

		textField_cusName = new JTextField();
		textField_cusName.setColumns(10);
		textField_cusName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cusName.setBounds(167, 75, 124, 19);
		cus_infor.add(textField_cusName);

		JLabel lblNewLabel_9_1_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_9_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_1_2.setBounds(347, 77, 66, 13);
		cus_infor.add(lblNewLabel_9_1_1_2);

		JLabel lblNewLabel_9_3_3 = new JLabel("Số điện thoại:");
		lblNewLabel_9_3_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3.setBounds(347, 32, 84, 13);
		cus_infor.add(lblNewLabel_9_3_3);

		textField_cusPhone = new JTextField();
		NumberTextField.numberTextField(textField_cusPhone);
		textField_cusPhone.setColumns(10);
		textField_cusPhone.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cusPhone.setBounds(439, 30, 124, 19);
		cus_infor.add(textField_cusPhone);

		textField_cusAddress = new JTextField();
		textField_cusAddress.setColumns(10);
		textField_cusAddress.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cusAddress.setBounds(439, 75, 124, 19);
		cus_infor.add(textField_cusAddress);

		JLabel lblNewLabel_9_3_3_1 = new JLabel("Giới tính:");
		lblNewLabel_9_3_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3_1.setBounds(620, 32, 55, 13);
		cus_infor.add(lblNewLabel_9_3_3_1);

		comboBox_cusSex = new JComboBox();
		comboBox_cusSex.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_cusSex.addItem("Chọn giới tính");
		comboBox_cusSex.addItem("Nam");
		comboBox_cusSex.addItem("Nữ");
		comboBox_cusSex.setBounds(669, 29, 100, 21);
		cus_infor.add(comboBox_cusSex);

		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3_2.setBounds(0, 172, 842, 328);
		panel_cusList.add(panel_3_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 21, 822, 297);
		panel_3_2.add(scrollPane_2);

		table_customer = new JTable();
//		table_customer.addMouseListener(adminCusController);
//		table_customer.addKeyListener(adminCusController);
		table_customer.setRowHeight(24);
		table_customer.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Gi\u1EDBi t\u00EDnh"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_customer.getColumnModel().getColumn(0).setResizable(false);
		table_customer.getColumnModel().getColumn(1).setResizable(false);
		table_customer.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_customer.getColumnModel().getColumn(2).setResizable(false);
		table_customer.getColumnModel().getColumn(3).setResizable(false);
		table_customer.getColumnModel().getColumn(3).setPreferredWidth(111);
		table_customer.getColumnModel().getColumn(4).setResizable(false);
		scrollPane_2.setViewportView(table_customer);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setLayout(null);
		panel_4_2.setBounds(0, 499, 842, 51);
		panel_cusList.add(panel_4_2);

		JButton btn_updateCus = new JButton("Lưu");
//		btn_updateCus.addActionListener(adminCusController);
		btn_updateCus.setBackground(new Color(149, 92, 211));
		btn_updateCus.setBounds(327, 15, 85, 21);
		panel_4_2.add(btn_updateCus);

		JButton btn_resetCus = new JButton("Làm mới");
//		btn_resetCus.addActionListener(adminCusController);
		btn_resetCus.setBackground(new Color(149, 92, 211));
		btn_resetCus.setBounds(422, 15, 85, 21);
		panel_4_2.add(btn_resetCus);

		JPanel panel_5_2 = new JPanel();
		panel_5_2.setLayout(null);
		panel_5_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_2.setBounds(0, 0, 842, 51);
		panel_cusList.add(panel_5_2);

		textField_cusFind = new JTextField();
//		textField_cusFind.addFocusListener(adminCusController);
		textField_cusFind.setColumns(10);
		textField_cusFind.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cusFind.setBackground(Color.WHITE);
		textField_cusFind.setBounds(98, 16, 347, 19);
		panel_5_2.add(textField_cusFind);

		JLabel lblNewLabel_8_2 = new JLabel("Tìm kiếm");
		lblNewLabel_8_2.setBounds(43, 19, 45, 13);
		panel_5_2.add(lblNewLabel_8_2);

		JButton btn_cusFind = new JButton("Tìm");
//		btn_cusFind.addActionListener(adminCusController);
		btn_cusFind.setBackground(new Color(149, 92, 211));
		btn_cusFind.setBounds(455, 15, 85, 21);
		panel_5_2.add(btn_cusFind);

		JPanel panel_accList = new JPanel();
		panel_accList.setLayout(null);
		panel_accList.setBackground(Color.WHITE);
		panel_cards.add(panel_accList, "panel_accList");

		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Danh s\u00E1ch t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3_3.setBounds(0, 172, 842, 328);
		panel_accList.add(panel_3_3);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 21, 822, 297);
		panel_3_3.add(scrollPane_3);

		table_account = new JTable();
//		table_account.addMouseListener(adminAccController);
//		table_account.addKeyListener(adminAccController);
		table_account.setRowHeight(24);
		table_account.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 t\u00E0i kho\u1EA3n", "T\u00EAn \u0111\u0103ng nh\u1EADp", "M\u1EADt kh\u1EA9u",
						"M\u00E3 quy\u1EC1n truy c\u1EADp", "M\u00E3 kh\u00E1ch h\u00E0ng" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_account.getColumnModel().getColumn(0).setResizable(false);
		table_account.getColumnModel().getColumn(1).setResizable(false);
		table_account.getColumnModel().getColumn(2).setResizable(false);
		table_account.getColumnModel().getColumn(3).setResizable(false);
		table_account.getColumnModel().getColumn(4).setResizable(false);
		scrollPane_3.setViewportView(table_account);

		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBounds(0, 499, 842, 51);
		panel_accList.add(panel_4_3);

		JButton btn_addAcc = new JButton("Thêm");
//		btn_addAcc.addActionListener(adminAccController);
		btn_addAcc.setBackground(new Color(149, 92, 211));
		btn_addAcc.setBounds(188, 15, 85, 21);
		panel_4_3.add(btn_addAcc);

		JButton btn_updateAcc = new JButton("Lưu");
//		btn_updateAcc.addActionListener(adminAccController);
		btn_updateAcc.setBackground(new Color(149, 92, 211));
		btn_updateAcc.setBounds(283, 15, 85, 21);
		panel_4_3.add(btn_updateAcc);

		JButton btn_deleteAcc = new JButton("Xóa");
//		btn_deleteAcc.addActionListener(adminAccController);
		btn_deleteAcc.setBackground(new Color(149, 92, 211));
		btn_deleteAcc.setBounds(378, 15, 85, 21);
		panel_4_3.add(btn_deleteAcc);

		JButton btn_deleteAllAcc = new JButton("Xóa tất cả");
//		btn_deleteAllAcc.addActionListener(adminAccController);
		btn_deleteAllAcc.setBackground(new Color(149, 92, 211));
		btn_deleteAllAcc.setBounds(473, 15, 85, 21);
		panel_4_3.add(btn_deleteAllAcc);

		JButton btn_resetAcc = new JButton("Làm mới");
//		btn_resetAcc.addActionListener(adminAccController);
		btn_resetAcc.setBackground(new Color(149, 92, 211));
		btn_resetAcc.setBounds(568, 15, 85, 21);
		panel_4_3.add(btn_resetAcc);

		JPanel panel_5_3 = new JPanel();
		panel_5_3.setLayout(null);
		panel_5_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_3.setBounds(0, 0, 842, 51);
		panel_accList.add(panel_5_3);

		textField_accFind = new JTextField();
//		textField_accFind.addFocusListener(adminAccController);
		textField_accFind.setColumns(10);
		textField_accFind.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_accFind.setBackground(Color.WHITE);
		textField_accFind.setBounds(98, 16, 347, 19);
		panel_5_3.add(textField_accFind);

		JLabel lblNewLabel_8_3 = new JLabel("Tìm kiếm");
		lblNewLabel_8_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_8_3.setBounds(43, 19, 45, 13);
		panel_5_3.add(lblNewLabel_8_3);

		JButton btn_accFind = new JButton("Tìm");
		btn_accFind.setFont(new Font("Tahoma", Font.PLAIN, 11));
//		btn_accFind.addActionListener(adminAccController);
		btn_accFind.setBackground(new Color(149, 92, 211));
		btn_accFind.setBounds(455, 15, 85, 21);
		panel_5_3.add(btn_accFind);

		JPanel acc_infor = new JPanel();
		acc_infor.setLayout(null);
		acc_infor.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Th\u00F4ng tin t\u00E0i kho\u1EA3n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		acc_infor.setBounds(0, 50, 842, 123);
		panel_accList.add(acc_infor);

		JLabel lblNewLabel_9_5_1 = new JLabel("Mã tài khoản:");
		lblNewLabel_9_5_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_5_1.setBounds(66, 32, 91, 13);
		acc_infor.add(lblNewLabel_9_5_1);

		JLabel lblNewLabel_9_1_3_1 = new JLabel("Mật khẩu:");
		lblNewLabel_9_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_3_1.setBounds(66, 77, 91, 13);
		acc_infor.add(lblNewLabel_9_1_3_1);

		textField_accId = new JTextField();
		textField_accId.setEditable(false);
		textField_accId.setColumns(10);
		textField_accId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_accId.setBounds(148, 30, 124, 19);
		acc_infor.add(textField_accId);

		textField_accPassword = new JTextField();
		textField_accPassword.setColumns(10);
		textField_accPassword.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_accPassword.setBounds(148, 75, 124, 19);
		acc_infor.add(textField_accPassword);

		JLabel lblNewLabel_9_1_1_2_1 = new JLabel("Quyền truy cập:");
		lblNewLabel_9_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_1_2_1.setBounds(316, 77, 92, 13);
		acc_infor.add(lblNewLabel_9_1_1_2_1);

		JLabel lblNewLabel_9_3_3_2 = new JLabel("Tên đăng nhập:");
		lblNewLabel_9_3_3_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3_2.setBounds(316, 32, 92, 13);
		acc_infor.add(lblNewLabel_9_3_3_2);

		textField_accUsername = new JTextField();
		textField_accUsername.setColumns(10);
		textField_accUsername.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_accUsername.setBounds(418, 30, 124, 19);
		acc_infor.add(textField_accUsername);

		JLabel lblNewLabel_9_3_3_1_1 = new JLabel("Mã khách hàng:");
		lblNewLabel_9_3_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3_1_1.setBounds(579, 32, 91, 13);
		acc_infor.add(lblNewLabel_9_3_3_1_1);

		textField_accCusId = new JTextField();
		textField_accCusId.setEditable(false);
		textField_accCusId.setColumns(10);
		textField_accCusId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_accCusId.setBounds(680, 30, 124, 19);
		acc_infor.add(textField_accCusId);

		comboBox_accAccessId = new JComboBox();
		comboBox_accAccessId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_accAccessId.addItem("Chọn quyền");
		comboBox_accAccessId.addItem("Administrator");
		comboBox_accAccessId.addItem("User");
		comboBox_accAccessId.setBounds(418, 74, 124, 19);
		acc_infor.add(comboBox_accAccessId);
		
		JPanel panel_receipt = new JPanel();
		panel_receipt.setName("");
		panel_cards.add(panel_receipt, "panel_receipt");
		panel_receipt.setLayout(null);
		
		JPanel panel_5_4 = new JPanel();
		panel_5_4.setLayout(null);
		panel_5_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),

						"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4.setBounds(0, 0, 842, 51);
		panel_receipt.add(panel_5_4);
		
		textField_receiptFind = new JTextField();
		textField_receiptFind.setColumns(10);
		textField_receiptFind.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_receiptFind.setBackground(Color.WHITE);
		textField_receiptFind.setBounds(98, 16, 347, 19);
		panel_5_4.add(textField_receiptFind);
		
		JLabel lblNewLabel_8_4 = new JLabel("Tìm kiếm");
		lblNewLabel_8_4.setBounds(43, 19, 45, 13);
		panel_5_4.add(lblNewLabel_8_4);
		
		JButton btn_receiptFind = new JButton("Tìm");
		btn_receiptFind.setBackground(new Color(149, 92, 211));
		btn_receiptFind.setBounds(455, 15, 85, 21);
		panel_5_4.add(btn_receiptFind);
		
		JComboBox comboBox_receiptMonth = new JComboBox();
		comboBox_receiptMonth.addItem("Tháng nhập hàng");
		for (int i = 1; i <= 12; i++) {
			comboBox_receiptMonth.addItem("Tháng " + i);
		}
		comboBox_receiptMonth.setBounds(690, 15, 113, 20);
		panel_5_4.add(comboBox_receiptMonth);
		
		JPanel product_infor_1 = new JPanel();
		product_infor_1.setLayout(null);
		product_infor_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		product_infor_1.setBounds(0, 50, 842, 112);
		panel_receipt.add(product_infor_1);
		
		JLabel lblNewLabel_9_4 = new JLabel("Mã phiếu nhập:");
		lblNewLabel_9_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_4.setBounds(53, 29, 91, 13);
		product_infor_1.add(lblNewLabel_9_4);
		
		JLabel lblNewLabel_9_1_2 = new JLabel("Mã nhà cung cấp:");
		lblNewLabel_9_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_2.setBounds(53, 71, 91, 13);
		product_infor_1.add(lblNewLabel_9_1_2);
		
		JLabel lblNewLabel_9_2_2 = new JLabel("Ngày nhập:");
		lblNewLabel_9_2_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2_2.setBounds(321, 71, 62, 13);
		product_infor_1.add(lblNewLabel_9_2_2);
		
		textField_receiptId = new JTextField();
		textField_receiptId.setEditable(false);
		textField_receiptId.setColumns(10);
		textField_receiptId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_receiptId.setBounds(140, 27, 126, 19);
		product_infor_1.add(textField_receiptId);
		
		textField_receiptTotalPrice = new JTextField();
		textField_receiptTotalPrice.setEditable(false);
		textField_receiptTotalPrice.setColumns(10);
		textField_receiptTotalPrice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_receiptTotalPrice.setBounds(654, 26, 126, 19);
		product_infor_1.add(textField_receiptTotalPrice);
		
		JLabel lblNewLabel_9_3_2 = new JLabel("Thành tiền:");
		lblNewLabel_9_3_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_2.setBounds(583, 29, 73, 13);
		product_infor_1.add(lblNewLabel_9_3_2);
		
		textField_receiptDate = new JTextField();
		textField_receiptDate.setEditable(false);
		textField_receiptDate.setColumns(10);
		textField_receiptDate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_receiptDate.setBounds(403, 68, 126, 19);
		product_infor_1.add(textField_receiptDate);
		
		JComboBox comboBox_receiptSuppId = new JComboBox();
		comboBox_receiptSuppId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_receiptSuppId.setBounds(140, 68, 126, 19);
		product_infor_1.add(comboBox_receiptSuppId);
		
		JLabel lblNewLabel_9_2_2_1 = new JLabel("Mã nhân viên:");
		lblNewLabel_9_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2_2_1.setBounds(321, 29, 91, 13);
		product_infor_1.add(lblNewLabel_9_2_2_1);
		
		textField_receiptAccId = new JTextField();
		textField_receiptAccId.setEditable(false);
		textField_receiptAccId.setColumns(10);
		textField_receiptAccId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_receiptAccId.setBounds(403, 26, 126, 19);
		product_infor_1.add(textField_receiptAccId);
		
		JPanel panel_3_4 = new JPanel();
		panel_3_4.setLayout(null);
		panel_3_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "Danh s\u00E1ch phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_4.setBounds(0, 161, 453, 338);
		panel_receipt.add(panel_3_4);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 22, 433, 308);
		panel_3_4.add(scrollPane_4);
		
		table_receipt = new JTable();
		table_receipt.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 phi\u1EBFu nh\u1EADp", "M\u00E3 t\u00E0i kho\u1EA3n", "M\u00E3 nh\u00E0 cung c\u1EA5p", "Th\u00E0nh ti\u1EC1n", "Ng\u00E0y t\u1EA1o phi\u1EBFu"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_receipt.getColumnModel().getColumn(0).setResizable(false);
		table_receipt.getColumnModel().getColumn(0).setPreferredWidth(105);
		table_receipt.getColumnModel().getColumn(1).setResizable(false);
		table_receipt.getColumnModel().getColumn(1).setPreferredWidth(104);
		table_receipt.getColumnModel().getColumn(2).setResizable(false);
		table_receipt.getColumnModel().getColumn(2).setPreferredWidth(120);
		table_receipt.getColumnModel().getColumn(3).setResizable(false);
		table_receipt.getColumnModel().getColumn(3).setPreferredWidth(117);
		table_receipt.getColumnModel().getColumn(4).setResizable(false);
		table_receipt.getColumnModel().getColumn(4).setPreferredWidth(135);
		scrollPane_4.setViewportView(table_receipt);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBounds(0, 499, 842, 51);
		panel_receipt.add(panel_4_1);
		
		JButton btn_addReceipt = new JButton("Tạo phiếu");
		btn_addReceipt.setBackground(new Color(149, 92, 211));
		btn_addReceipt.setBounds(188, 15, 85, 21);
		panel_4_1.add(btn_addReceipt);
		
		JButton btn_updateReceipt = new JButton("Lưu phiếu");
		btn_updateReceipt.setBackground(new Color(149, 92, 211));
		btn_updateReceipt.setBounds(283, 15, 85, 21);
		panel_4_1.add(btn_updateReceipt);
		
		JButton btn_deleteReceipt = new JButton("Xóa phiếu");
		btn_deleteReceipt.setBackground(new Color(149, 92, 211));
		btn_deleteReceipt.setBounds(378, 15, 85, 21);
		panel_4_1.add(btn_deleteReceipt);
		
		JButton btn_deleteAllReceipt = new JButton("Xóa tất cả");
		btn_deleteAllReceipt.setBackground(new Color(149, 92, 211));
		btn_deleteAllReceipt.setBounds(473, 15, 85, 21);
		panel_4_1.add(btn_deleteAllReceipt);
		
		JButton btn_resetReceipt = new JButton("Làm mới");
		btn_resetReceipt.setBackground(new Color(149, 92, 211));
		btn_resetReceipt.setBounds(568, 15, 85, 21);
		panel_4_1.add(btn_resetReceipt);
		
		JPanel panel_3_4_1 = new JPanel();
		panel_3_4_1.setLayout(null);
		panel_3_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "Danh s\u00E1ch h\u00E0ng nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_4_1.setBounds(477, 236, 365, 232);
		panel_receipt.add(panel_3_4_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 20, 345, 202);
		panel_3_4_1.add(scrollPane_5);
		
		table_receiptProd = new JTable();
		table_receiptProd.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_receiptProd.getColumnModel().getColumn(0).setResizable(false);
		table_receiptProd.getColumnModel().getColumn(1).setResizable(false);
		table_receiptProd.getColumnModel().getColumn(1).setPreferredWidth(115);
		table_receiptProd.getColumnModel().getColumn(2).setResizable(false);
		table_receiptProd.getColumnModel().getColumn(3).setResizable(false);
		scrollPane_5.setViewportView(table_receiptProd);
		
		JLabel lblNewLabel_9_2_2_1_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_9_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2_2_1_1.setBounds(487, 175, 77, 13);
		panel_receipt.add(lblNewLabel_9_2_2_1_1);
		
		JComboBox comboBox_receiptProdId = new JComboBox();
		comboBox_receiptProdId.addItem("Chọn mã");
		comboBox_receiptProdId.setBounds(563, 172, 77, 19);
		panel_receipt.add(comboBox_receiptProdId);
		
		JLabel lblNewLabel_9_2_2_1_1_1 = new JLabel("Số lượng:");
		lblNewLabel_9_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2_2_1_1_1.setBounds(680, 175, 66, 13);
		panel_receipt.add(lblNewLabel_9_2_2_1_1_1);
		
		textField_receiptQuantity = new JTextField();
		NumberTextField.numberTextField(textField_receiptQuantity);
		textField_receiptQuantity.setColumns(10);
		textField_receiptQuantity.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_receiptQuantity.setBounds(737, 172, 77, 19);
		panel_receipt.add(textField_receiptQuantity);
		
		JButton btnReceipt_addProduct = new JButton("Thêm");
		btnReceipt_addProduct.setBackground(new Color(149, 92, 211));
		btnReceipt_addProduct.setBounds(584, 478, 85, 21);
		panel_receipt.add(btnReceipt_addProduct);
		
		JButton btnReceipt_deleteProd = new JButton("Xóa");
		btnReceipt_deleteProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReceipt_deleteProd.setBackground(new Color(149, 92, 211));
		btnReceipt_deleteProd.setBounds(681, 478, 85, 21);
		panel_receipt.add(btnReceipt_deleteProd);
		
		JLabel lblNewLabel_9_2_2_2 = new JLabel("Giá nhập:");
		lblNewLabel_9_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2_2_2.setBounds(488, 208, 62, 13);
		panel_receipt.add(lblNewLabel_9_2_2_2);
		
		textField_receiptPrice = new JTextField();
		NumberTextField.numberTextField(textField_receiptPrice);
		textField_receiptPrice.setColumns(10);
		textField_receiptPrice.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_receiptPrice.setBounds(563, 207, 106, 19);
		panel_receipt.add(textField_receiptPrice);
		
		JPanel panel_category = new JPanel();
		panel_category.setLayout(null);
		panel_category.setName("");
		panel_cards.add(panel_category, "panel_category");
		
		JPanel panel_5_4_1 = new JPanel();
		panel_5_4_1.setLayout(null);
		panel_5_4_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),

		

								"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5_4_1.setBounds(0, 0, 842, 51);
		panel_category.add(panel_5_4_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField.setBackground(Color.WHITE);
		textField.setBounds(98, 16, 347, 19);
		panel_5_4_1.add(textField);
		
		JLabel lblNewLabel_8_4_1 = new JLabel("Tìm kiếm");
		lblNewLabel_8_4_1.setBounds(43, 19, 45, 13);
		panel_5_4_1.add(lblNewLabel_8_4_1);
		
		JButton btn_receiptFind_1 = new JButton("Tìm");
		btn_receiptFind_1.setBackground(new Color(149, 92, 211));
		btn_receiptFind_1.setBounds(455, 15, 85, 21);
		panel_5_4_1.add(btn_receiptFind_1);
		
		JPanel product_infor_1_1 = new JPanel();
		product_infor_1_1.setLayout(null);
		product_infor_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "Th\u00F4ng tin lo\u1EA1i h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		product_infor_1_1.setBounds(0, 50, 842, 112);
		panel_category.add(product_infor_1_1);
		
		JLabel lblNewLabel_9_4_1 = new JLabel("Mã loại hàng:");
		lblNewLabel_9_4_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_4_1.setBounds(53, 29, 91, 13);
		product_infor_1_1.add(lblNewLabel_9_4_1);
		
		JLabel lblNewLabel_9_1_2_1 = new JLabel("Tên loại hàng:");
		lblNewLabel_9_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_2_1.setBounds(53, 71, 91, 13);
		product_infor_1_1.add(lblNewLabel_9_1_2_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_1.setBounds(140, 27, 126, 19);
		product_infor_1_1.add(textField_1);
		
		JLabel lblNewLabel_9_2_2_1_2 = new JLabel("Mô tả:");
		lblNewLabel_9_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2_2_1_2.setBounds(348, 29, 45, 13);
		product_infor_1_1.add(lblNewLabel_9_2_2_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_4.setBounds(403, 26, 347, 19);
		product_infor_1_1.add(textField_4);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_2.setBounds(140, 68, 126, 19);
		product_infor_1_1.add(textField_2);
		
		JPanel panel_3_4_2 = new JPanel();
		panel_3_4_2.setLayout(null);
		panel_3_4_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "Danh s\u00E1ch lo\u1EA1i h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_4_2.setBounds(0, 161, 842, 338);
		panel_category.add(panel_3_4_2);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 21, 822, 307);
		panel_3_4_2.add(scrollPane_6);
		
		table_category = new JTable();
		table_category.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 lo\u1EA1i h\u00E0ng", "T\u00EAn lo\u1EA1i h\u00E0ng", "M\u00F4 t\u1EA3"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_category.getColumnModel().getColumn(0).setResizable(false);
		table_category.getColumnModel().getColumn(1).setResizable(false);
		table_category.getColumnModel().getColumn(1).setPreferredWidth(124);
		table_category.getColumnModel().getColumn(2).setResizable(false);
		table_category.getColumnModel().getColumn(2).setPreferredWidth(368);
		scrollPane_6.setViewportView(table_category);
		
		JPanel panel_4_1_1 = new JPanel();
		panel_4_1_1.setLayout(null);
		panel_4_1_1.setBounds(0, 499, 842, 51);
		panel_category.add(panel_4_1_1);
		
		JButton btn_addCategory = new JButton("Thêm");
		btn_addCategory.setBackground(new Color(149, 92, 211));
		btn_addCategory.setBounds(188, 15, 85, 21);
		panel_4_1_1.add(btn_addCategory);
		
		JButton btn_updateCategory = new JButton("Sửa");
		btn_updateCategory.setBackground(new Color(149, 92, 211));
		btn_updateCategory.setBounds(283, 15, 85, 21);
		panel_4_1_1.add(btn_updateCategory);
		
		JButton btn_deleteCategory = new JButton("Xóa");
		btn_deleteCategory.setBackground(new Color(149, 92, 211));
		btn_deleteCategory.setBounds(378, 15, 85, 21);
		panel_4_1_1.add(btn_deleteCategory);
		
		JButton btn_deleteAllCategory = new JButton("Xóa tất cả");
		btn_deleteAllCategory.setBackground(new Color(149, 92, 211));
		btn_deleteAllCategory.setBounds(473, 15, 85, 21);
		panel_4_1_1.add(btn_deleteAllCategory);
		
		JButton btn_resetCategory = new JButton("Làm mới");
		btn_resetCategory.setBackground(new Color(149, 92, 211));
		btn_resetCategory.setBounds(568, 15, 85, 21);
		panel_4_1_1.add(btn_resetCategory);
		
		JPanel panel_analytics = new JPanel();
		panel_cards.add(panel_analytics, "panel_analytics");

		JPanel panel_header = new JPanel();
		panel_header.setBackground(new Color(100, 98, 179));
		panel_header.setBounds(241, 0, 842, 71);
		contentPane.add(panel_header);
		panel_header.setLayout(null);

		lbl_header = new JLabel("Quản lý sản phẩm");
		lbl_header.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_header.setBounds(53, 22, 209, 35);
		panel_header.add(lbl_header);

		JLabel lblNewLabel_7 = new JLabel("Adminstrations");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_7.setBounds(70, 0, 148, 24);
		panel_header.add(lblNewLabel_7);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(69, 22, 176, 2);
		panel_header.add(separator_1);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(53, 55, 300, 2);
		panel_header.add(separator_3_1);

		this.setVisible(true);

		// Quoc Tuan
		AccountController_QT.loadAccount(table_account);
		JOptionPane.showMessageDialog(null, "Success!");
		// End
	}

	public void setColor(JPanel jPanel) {
		jPanel.setBackground(new Color(123, 54, 199));
		jPanel.setForeground(getForeground());
	}

	public void resetColor(JPanel jPanel) {
		jPanel.setBackground(new Color(84, 40, 132));
	}

	public void handleSetColor(JPanel panel) {
		if (!this.currentJPanel.equals(panel)) {
			this.setColor(panel);
			this.resetColor(this.currentJPanel);
			this.currentJPanel = panel;
		}
	}

	public void handleShowCart(JPanel panel) {
		CardLayout cardLayout = (CardLayout) this.panel_cards.getLayout();
		if (panel.getName().equals("productList")) {
			this.lbl_header.setText("Quản lý sản phẩm");
			cardLayout.show(panel_cards, "panel_productList");
			
		} else if (panel.getName().equals("orderList")) {
			this.lbl_header.setText("Quản lý đơn hàng");
//			this.showListOrderToTable(this.customerOrders);
			cardLayout.show(panel_cards, "panel_orderList");
			
		} else if (panel.getName().equals("cusList")) {
//			this.showListCusToTable(this.customers);
			this.lbl_header.setText("Quản lý khách hàng");
			cardLayout.show(panel_cards, "panel_cusList");
			
		} else if (panel.getName().equals("accList")) {
			this.lbl_header.setText("Quản lý tài khoản");
			cardLayout.show(panel_cards, "panel_accList");
			
		} else if (panel.getName().equals("receipt")) {
			this.lbl_header.setText("Quản lý nhập hàng");
			cardLayout.show(panel_cards, "panel_receipt");

		} else if (panel.getName().equals("category")) {
			this.lbl_header.setText("Quản lý loại hàng");
			cardLayout.show(panel_cards, "panel_category");
			
		} else if (panel.getName().equals("analytics")) {
			this.lbl_header.setText("Thống kê");
			cardLayout.show(panel_cards, "panel_analytics");
		}
	}

// Card Account
	public void formClearAccount() {
		this.textField_accFind.setText("");
		this.textField_accId.setText("");
		this.textField_accUsername.setText("");
		this.textField_accPassword.setText("");
		this.comboBox_accAccessId.setSelectedIndex(0);
		this.textField_accCusId.setText("");
	}

	public void handleFormClearAcc() {
		this.formClearAccount();
//		this.showListAccToTable(this.access.getAccounts());
	}

	
	public void showAccDataToComponents(int row) {
		DefaultTableModel tableAccModel = (DefaultTableModel) this.table_account.getModel();
		String id = tableAccModel.getValueAt(row, 0) + "";
		String username = tableAccModel.getValueAt(row, 1) + "";
		String password = tableAccModel.getValueAt(row, 2) + "";
		String accsId = tableAccModel.getValueAt(row, 3) + "";
		if (accsId.equals("ADMIN")) {
			accsId = "Administrator";
		} else {
			accsId = "User";
		}
		String cusId = tableAccModel.getValueAt(row, 4) + "";

		this.textField_accId.setText(id);
		this.textField_accUsername.setText(username);
		this.textField_accPassword.setText(password);
		this.comboBox_accAccessId.setSelectedItem(accsId);
		this.textField_accCusId.setText(cusId);
	}
}
