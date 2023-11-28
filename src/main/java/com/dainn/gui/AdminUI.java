package com.dainn.gui;

import com.dainn.controller.admin.*;
import com.dainn.dto.*;
import com.dainn.service.*;
import com.dainn.service.impl.*;
import com.dainn.utils.ImageUtil;
import com.dainn.utils.NumberTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

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
	public JTextField txtNhpMn;
	public JTextField txtidCustomer;
	public JTextField txtnameCustomer;
	public JTextField txtphoneCustomer;
	public JTextField txtaddressCustomer;
	public JTextField txtFindCus;
	public JTextField txtFindAcc;
	public JTable table_order;
	public JTable table_customer;
	public JTextField txtIdAcc;
	public JTextField txtPasswordAcc;
	public JTextField txtUsernameAcc;
	public JTable table_account;
	public JTextField txtFullNameAcc;
	public JLabel lbl_header;
	public JComboBox<String> cbbRoleAcc;
	public JLabel lbl_image;
	public JComboBox comboBox_prodCateId;
	public JButton btn_orderFind;
	public JComboBox<Object> comboBox_orderMonth;
	public JTextField textField_receiptFind;
	public JTextField textField_receiptId;
	public JTextField textField_receiptTotalPrice;
	public JTextField textField_receiptDate;
	public JTable table_receipt;
	private JTextField textField_receiptAccId;
	public JTextField textField_cateFind;
	public JTextField textField_cateId;
	public JTextField textField_cateDescription;
	public JTextField textField_cateName;
	public JTable table_category;
	private JTextField txtpointCustomer;
	public JTable table_analyticCate;
	public JTable table_analyticProduct;
	public JTable table_analyticEmployee;
	private JPanel panel_analytic;
	public JDateChooser toDateChooser;
	public JDateChooser fromDateChooser;
	public static int currentStatistic = 0;
	private JTextField txtPhoneAcc;
	public JComboBox comboBox_receiptSuppId;
	public JComboBox comboBox_receiptMonth;

	private IStatisticService statisticService = new StatisticService();
	public IReceiptService receiptService = new ReceiptService();
	public ICategoryService categoryService = new CategoryService();
	private ISupplierService supplierService = new SupplierService();
	public IProductService productService = new ProductService();
	public List<StatisticDTO> statistics = new ArrayList<>();

	public AdminUI(AccountDTO account) {
		this.init();
		this.accountDTO = account;
		showListProductToTable(productService.findAll(1));
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
		AdminAnalyticsController adminAnalyticsController = new AdminAnalyticsController(this);
		AdminReceiptController adminReceiptController = new AdminReceiptController(this);
		AdminProductController adminProductController = new AdminProductController(this);
		AdminCategoryController adminCategoryController = new AdminCategoryController(this);

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
		lblNewLabel.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8_products.png")));
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
		lblNewLabel_2.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-customer-38.png")));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 3, 40, 40);
		btn_cusList.add(lblNewLabel_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("Quản lý khách hàng");
		lblNewLabel_1_2_1.setFont(new Font("Arial", lblNewLabel_1_2_1.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_2_1.getFont().getSize() + 6));
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
		lblNewLabel_1_2.setFont(new Font("Arial", lblNewLabel_1_2.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_2.getFont().getSize() + 6));
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
		lblNewLabel_4.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-male-user-38.png")));
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 3, 40, 40);
		btn_accList.add(lblNewLabel_4);

		JLabel lblNewLabel_1_2_2 = new JLabel("Quản lý tài khoản");
		lblNewLabel_1_2_2.setFont(new Font("Arial", lblNewLabel_1_2_2.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_2_2.getFont().getSize() + 6));
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
		lblNewLabel_1_1.setFont(new Font("Arial", lblNewLabel_1_1.getFont().getStyle() | Font.BOLD,
				lblNewLabel_1_1.getFont().getSize() + 6));
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
		lbl_logOut.setBackground(new Color(128, 0, 255));
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

		JLabel lblNewLabel_1_1_1 = new JLabel("Quản lý danh mục");
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
		NumberTextField.numberTextFieldStartWithoutZero(textField_proPrice);
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
		btn_proSelectImg.addActionListener(adminProductController);
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
		for (CategoryDTO category : categoryService.findAll(1)) {
			comboBox_prodCateId.addItem(category.getName());
		}
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
		table_product.addMouseListener(adminProductController);
		table_product.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table_product.setRowHeight(24);
		table_product.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 s\u1EA3n ph\u1EA9m", "T\u00EAn s\u1EA3n ph\u1EA9m", "\u0110\u01A1n gi\u00E1",
						"S\u1ED1 l\u01B0\u1EE3ng", "Lo\u1EA1i s\u1EA3n ph\u1EA9m", "Image" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

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
		table_product.getColumnModel().getColumn(5).setPreferredWidth(200);
		table_product.getColumnModel().getColumn(5).setMinWidth(200);
		scrollPane.setViewportView(table_product);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 499, 842, 51);
		panel_productList.add(panel_4);
		panel_4.setLayout(null);

		JButton btn_addProduct = new JButton("Thêm");
		btn_addProduct.addActionListener(adminProductController);
		btn_addProduct.setBackground(new Color(149, 92, 211));
		btn_addProduct.setBounds(188, 15, 85, 21);
		panel_4.add(btn_addProduct);

		JButton btn_updateProduct = new JButton("Lưu");
		btn_updateProduct.addActionListener(adminProductController);
		btn_updateProduct.setBackground(new Color(149, 92, 211));
		btn_updateProduct.setBounds(283, 15, 85, 21);
		panel_4.add(btn_updateProduct);

		JButton btn_deleteProduct = new JButton("Xóa");
		btn_deleteProduct.addActionListener(adminProductController);
		btn_deleteProduct.setBackground(new Color(149, 92, 211));
		btn_deleteProduct.setBounds(378, 15, 85, 21);
		panel_4.add(btn_deleteProduct);

		JButton btn_deleteAllProduct = new JButton("Xóa tất cả");
		btn_deleteAllProduct.addActionListener(adminProductController);
		btn_deleteAllProduct.setBackground(new Color(149, 92, 211));
		btn_deleteAllProduct.setBounds(473, 15, 85, 21);
		panel_4.add(btn_deleteAllProduct);

		JButton btn_resetProduct = new JButton("Làm mới");
		btn_resetProduct.addActionListener(adminProductController);
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
		btn_proFind.addActionListener(adminProductController);
		btn_proFind.setBackground(new Color(149, 92, 211));
		btn_proFind.setBounds(455, 15, 85, 21);
		panel_5.add(btn_proFind);

		JPanel panel_orderList = new JPanel();
		panel_orderList.setLayout(null);
		panel_orderList.setBackground(Color.WHITE);
		panel_cards.add(panel_orderList, "panel_orderList");

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(null);
		panel_3_1.setBounds(0, 58, 842, 422);
		panel_orderList.add(panel_3_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		scrollPane_1.setBounds(10, 10, 822, 399);
		panel_3_1.add(scrollPane_1);

		table_order = new JTable();
		table_order.setRowHeight(24);
		table_order.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 \u0111\u01A1n h\u00E0ng", "Mã kh\u00E1ch h\u00E0ng", "Mã nh\u00E2n vi\u00EAn",
						"Ng\u00E0y \u0111\u1EB7t h\u00E0ng", "T\u1ED5ng ti\u1EC1n" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_order.getColumnModel().getColumn(0).setResizable(false);
		table_order.getColumnModel().getColumn(1).setResizable(false);
		table_order.getColumnModel().getColumn(1).setPreferredWidth(120);
		table_order.getColumnModel().getColumn(2).setResizable(false);
		table_order.getColumnModel().getColumn(3).setResizable(false);
		table_order.getColumnModel().getColumn(3).setPreferredWidth(126);
		table_order.getColumnModel().getColumn(4).setResizable(false);
		table_order.getColumnModel().getColumn(4).setPreferredWidth(145);
		scrollPane_1.setViewportView(table_order);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setBorder(null);
		panel_5_1.setBounds(0, 0, 842, 59);
		panel_orderList.add(panel_5_1);

		txtNhpMn = new JTextField();
		txtNhpMn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNhpMn.setColumns(10);
		txtNhpMn.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtNhpMn.setBackground(Color.WHITE);
		txtNhpMn.setBounds(146, 28, 217, 20);
		panel_5_1.add(txtNhpMn);

		JLabel lblNewLabel_8_1 = new JLabel("Tìm kiếm");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8_1.setBounds(84, 32, 56, 15);
		panel_5_1.add(lblNewLabel_8_1);

		btn_orderFind = new JButton("Tìm");
		btn_orderFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_orderFind.setBackground(new Color(149, 92, 211));
		btn_orderFind.setBounds(393, 29, 65, 20);
		panel_5_1.add(btn_orderFind);

		comboBox_orderMonth = new JComboBox<Object>();
		comboBox_orderMonth.setModel(new DefaultComboBoxModel<Object>(new String[] { "Tìm theo Tháng" }));
		comboBox_orderMonth.setToolTipText("");
		comboBox_orderMonth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		for (int i = 1; i <= 12; i++) {
			comboBox_orderMonth.addItem(i);
		}
		comboBox_orderMonth.setBounds(703, 24, 129, 28);
		panel_5_1.add(comboBox_orderMonth);

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
		lblNewLabel_9_5.setBounds(92, 29, 101, 17);
		cus_infor.add(lblNewLabel_9_5);

		JLabel lblNewLabel_9_1_3 = new JLabel("Tên khách hàng:");
		lblNewLabel_9_1_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_3.setBounds(92, 75, 106, 17);
		cus_infor.add(lblNewLabel_9_1_3);

		txtidCustomer = new JTextField();
		txtidCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtidCustomer.setEditable(false);
		txtidCustomer.setColumns(10);
		txtidCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtidCustomer.setBounds(203, 28, 124, 19);
		cus_infor.add(txtidCustomer);

		txtnameCustomer = new JTextField();
		txtnameCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtnameCustomer.setColumns(10);
		txtnameCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtnameCustomer.setBounds(203, 75, 124, 19);
		cus_infor.add(txtnameCustomer);

		JLabel lblNewLabel_9_1_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_9_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_1_2.setBounds(363, 75, 48, 17);
		cus_infor.add(lblNewLabel_9_1_1_2);

		JLabel lblNewLabel_9_3_3 = new JLabel("Số điện thoại:");
		lblNewLabel_9_3_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3.setBounds(363, 29, 88, 17);
		cus_infor.add(lblNewLabel_9_3_3);

		txtphoneCustomer = new JTextField();
		txtphoneCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		NumberTextField.numberTextField(txtphoneCustomer);
		txtphoneCustomer.setColumns(10);
		txtphoneCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtphoneCustomer.setBounds(461, 28, 124, 19);
		cus_infor.add(txtphoneCustomer);

		txtaddressCustomer = new JTextField();
		txtaddressCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtaddressCustomer.setColumns(10);
		txtaddressCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtaddressCustomer.setBounds(461, 75, 124, 19);
		cus_infor.add(txtaddressCustomer);

		JLabel lblNewLabel_10 = new JLabel("Điểm:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_10.setBounds(628, 20, 45, 34);
		cus_infor.add(lblNewLabel_10);

		txtpointCustomer = new JTextField();
		txtpointCustomer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtpointCustomer.setColumns(10);
		txtpointCustomer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtpointCustomer.setBounds(683, 29, 124, 19);
		cus_infor.add(txtpointCustomer);

		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(null);
		panel_3_2.setBounds(0, 172, 842, 328);
		panel_cusList.add(panel_3_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 23, 822, 305);
		panel_3_2.add(scrollPane_2);

		table_customer = new JTable();
		table_customer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_customer.setRowHeight(24);
		table_customer.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng",
						"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9", "Tích điểm" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

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
		btn_updateCus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_updateCus.setBackground(new Color(149, 92, 211));
		btn_updateCus.setBounds(327, 12, 85, 26);
		panel_4_2.add(btn_updateCus);

		JButton btn_deleteCus = new JButton("Xóa");
		btn_deleteCus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_deleteCus.setBackground(new Color(149, 92, 211));
		btn_deleteCus.setBounds(422, 12, 85, 26);
		panel_4_2.add(btn_deleteCus);

		JButton btnReloadCus = new JButton("Reload");
		btnReloadCus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReloadCus.setBackground(new Color(149, 92, 211));
		btnReloadCus.setBounds(517, 12, 85, 26);
		panel_4_2.add(btnReloadCus);

		JPanel panel_5_2 = new JPanel();
		panel_5_2.setLayout(null);
		panel_5_2.setBorder(null);
		panel_5_2.setBounds(0, 0, 842, 51);
		panel_cusList.add(panel_5_2);

		txtFindCus = new JTextField();
		txtFindCus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFindCus.setColumns(10);
		txtFindCus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtFindCus.setBackground(Color.WHITE);
		txtFindCus.setBounds(217, 16, 347, 19);
		panel_5_2.add(txtFindCus);

		JLabel lblNewLabel_8_2 = new JLabel("Tìm kiếm");
		lblNewLabel_8_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_2.setBounds(137, 18, 58, 17);
		panel_5_2.add(lblNewLabel_8_2);

		JButton btn_cusFind = new JButton("Tìm");
		btn_cusFind.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_cusFind.setBackground(new Color(149, 92, 211));
		btn_cusFind.setBounds(619, 15, 85, 21);
		panel_5_2.add(btn_cusFind);

		JPanel panel_accList = new JPanel();
		panel_accList.setLayout(null);
		panel_accList.setBackground(Color.WHITE);
		panel_cards.add(panel_accList, "panel_accList");

		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3_3.setBounds(0, 172, 842, 328);
		panel_accList.add(panel_3_3);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 22, 822, 306);
		panel_3_3.add(scrollPane_3);

		table_account = new JTable();
		table_account.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_account.setRowHeight(24);
		table_account.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 t\u00E0i kho\u1EA3n", "T\u00EAn \u0111\u0103ng nh\u1EADp", "M\u1EADt kh\u1EA9u",
						"M\u00E3 quy\u1EC1n truy c\u1EADp", "Tên", "Số điện thoại" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_account.getColumnModel().getColumn(0).setResizable(false);
		table_account.getColumnModel().getColumn(1).setResizable(false);
		table_account.getColumnModel().getColumn(2).setResizable(false);
		table_account.getColumnModel().getColumn(3).setResizable(false);
		table_account.getColumnModel().getColumn(4).setResizable(false);
		table_account.getColumnModel().getColumn(5).setResizable(false);
		scrollPane_3.setViewportView(table_account);

		JPanel panel_4_3 = new JPanel();
		panel_4_3.setLayout(null);
		panel_4_3.setBounds(0, 499, 842, 51);
		panel_accList.add(panel_4_3);

		final JButton btn_addAcc = new JButton("Thêm");
		btn_addAcc.setFont(new Font("Dialog", Font.PLAIN, 12));
		btn_addAcc.setBackground(new Color(149, 92, 211));
		btn_addAcc.setBounds(226, 12, 85, 26);
		panel_4_3.add(btn_addAcc);

		final JButton btn_updateAcc = new JButton("Lưu");
		btn_updateAcc.setFont(new Font("Dialog", Font.PLAIN, 12));
		btn_updateAcc.setBackground(new Color(149, 92, 211));
		btn_updateAcc.setBounds(321, 12, 85, 26);
		panel_4_3.add(btn_updateAcc);

		final JButton btn_deleteAcc = new JButton("Xóa");
		btn_deleteAcc.setFont(new Font("Dialog", Font.PLAIN, 12));
		btn_deleteAcc.setBackground(new Color(149, 92, 211));
		btn_deleteAcc.setBounds(416, 12, 85, 26);
		panel_4_3.add(btn_deleteAcc);

		final JButton btn_resetAcc = new JButton("Reload");
		btn_resetAcc.setFont(new Font("Dialog", Font.PLAIN, 12));
		btn_resetAcc.setBackground(new Color(149, 92, 211));
		btn_resetAcc.setBounds(511, 12, 85, 26);
		panel_4_3.add(btn_resetAcc);

		JPanel panel_5_3 = new JPanel();
		panel_5_3.setLayout(null);
		panel_5_3.setBorder(null);
		panel_5_3.setBounds(0, 0, 842, 51);
		panel_accList.add(panel_5_3);

		txtFindAcc = new JTextField();
		txtFindAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtFindAcc.setColumns(10);
		txtFindAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtFindAcc.setBackground(Color.WHITE);
		txtFindAcc.setBounds(232, 16, 347, 19);
		panel_5_3.add(txtFindAcc);

		JLabel lblNewLabel_8_3 = new JLabel("Tìm kiếm");
		lblNewLabel_8_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8_3.setBounds(155, 19, 58, 17);
		panel_5_3.add(lblNewLabel_8_3);

		JButton btn_accFind = new JButton("Tìm");
		btn_accFind.setFont(new Font("Dialog", Font.PLAIN, 12));
		btn_accFind.setBackground(new Color(149, 92, 211));
		btn_accFind.setBounds(619, 15, 85, 21);
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
		lblNewLabel_9_5_1.setBounds(66, 32, 86, 17);
		acc_infor.add(lblNewLabel_9_5_1);

		JLabel lblNewLabel_9_1_3_1 = new JLabel("Mật khẩu:");
		lblNewLabel_9_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_3_1.setBounds(66, 77, 63, 17);
		acc_infor.add(lblNewLabel_9_1_3_1);

		txtIdAcc = new JTextField();
		txtIdAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtIdAcc.setEditable(false);
		txtIdAcc.setColumns(10);
		txtIdAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtIdAcc.setBounds(159, 30, 124, 19);
		acc_infor.add(txtIdAcc);

		txtPasswordAcc = new JTextField();
		txtPasswordAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPasswordAcc.setColumns(10);
		txtPasswordAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtPasswordAcc.setBounds(159, 78, 124, 19);
		acc_infor.add(txtPasswordAcc);

		JLabel lblNewLabel_9_1_1_2_1 = new JLabel("Quyền truy cập:");
		lblNewLabel_9_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_1_2_1.setBounds(316, 77, 102, 17);
		acc_infor.add(lblNewLabel_9_1_1_2_1);

		JLabel lblNewLabel_9_3_3_2 = new JLabel("Tên đăng nhập:");
		lblNewLabel_9_3_3_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3_2.setBounds(316, 32, 101, 17);
		acc_infor.add(lblNewLabel_9_3_3_2);

		txtUsernameAcc = new JTextField();
		txtUsernameAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtUsernameAcc.setColumns(10);
		txtUsernameAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtUsernameAcc.setBounds(433, 31, 124, 19);
		acc_infor.add(txtUsernameAcc);

		JLabel lblNewLabel_9_3_3_1_1 = new JLabel("Tên:");
		lblNewLabel_9_3_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3_1_1.setBounds(611, 32, 29, 17);
		acc_infor.add(lblNewLabel_9_3_3_1_1);

		txtFullNameAcc = new JTextField();
		txtFullNameAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtFullNameAcc.setColumns(10);
		txtFullNameAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtFullNameAcc.setBounds(659, 31, 124, 19);
		acc_infor.add(txtFullNameAcc);

		cbbRoleAcc = new JComboBox<String>();
		cbbRoleAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cbbRoleAcc.addItem("STAFF");
		cbbRoleAcc.addItem("ADMIN");
		cbbRoleAcc.setBounds(433, 73, 124, 21);
		acc_infor.add(cbbRoleAcc);

		txtPhoneAcc = new JTextField();
		txtPhoneAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtPhoneAcc.setColumns(10);
		txtPhoneAcc.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		txtPhoneAcc.setBounds(659, 76, 124, 19);
		acc_infor.add(txtPhoneAcc);

		JLabel lblNewLabel_9_3_3_1_1_1 = new JLabel("Số ĐT:");
		lblNewLabel_9_3_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_3_3_1_1_1.setBounds(611, 79, 34, 14);
		acc_infor.add(lblNewLabel_9_3_3_1_1_1);

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
		btn_receiptFind.addActionListener(adminReceiptController);
		btn_receiptFind.setBackground(new Color(149, 92, 211));
		btn_receiptFind.setBounds(455, 15, 85, 21);
		panel_5_4.add(btn_receiptFind);

		comboBox_receiptMonth = new JComboBox();
		comboBox_receiptMonth.addActionListener(adminReceiptController);
		comboBox_receiptMonth.addItem("Tháng nhập hàng");
		for (int i = 1; i <= 12; i++) {
			comboBox_receiptMonth.addItem(i);
		}
		comboBox_receiptMonth.setBounds(690, 15, 113, 20);
		panel_5_4.add(comboBox_receiptMonth);

		JPanel product_infor_1 = new JPanel();
		product_infor_1.setLayout(null);
		product_infor_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Th\u00F4ng tin phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
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

		comboBox_receiptSuppId = new JComboBox();
		for (SupplierDTO suppl : supplierService.findAll()) {
			comboBox_receiptSuppId.addItem(suppl.getId());
		}
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
		panel_3_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Danh s\u00E1ch phi\u1EBFu nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_3_4.setBounds(0, 161, 842, 338);
		panel_receipt.add(panel_3_4);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 22, 822, 308);
		panel_3_4.add(scrollPane_4);

		table_receipt = new JTable();
		table_receipt.addMouseListener(adminReceiptController);
		table_receipt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_receipt.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 phi\u1EBFu nh\u1EADp", "M\u00E3 t\u00E0i kho\u1EA3n",
						"M\u00E3 nh\u00E0 cung c\u1EA5p", "Th\u00E0nh ti\u1EC1n", "Ng\u00E0y t\u1EA1o phi\u1EBFu" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

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

		JButton btn_updateReceipt = new JButton("Lưu phiếu");
		btn_updateReceipt.addActionListener(adminReceiptController);
		btn_updateReceipt.setBackground(new Color(149, 92, 211));
		btn_updateReceipt.setBounds(241, 15, 85, 21);
		panel_4_1.add(btn_updateReceipt);

		JButton btn_deleteReceipt = new JButton("Xóa phiếu");
		btn_deleteReceipt.addActionListener(adminReceiptController);
		btn_deleteReceipt.setBackground(new Color(149, 92, 211));
		btn_deleteReceipt.setBounds(336, 15, 85, 21);
		panel_4_1.add(btn_deleteReceipt);

		JButton btn_deleteAllReceipt = new JButton("Xóa tất cả");
		btn_deleteAllReceipt.addActionListener(adminReceiptController);
		btn_deleteAllReceipt.setBackground(new Color(149, 92, 211));
		btn_deleteAllReceipt.setBounds(431, 15, 85, 21);
		panel_4_1.add(btn_deleteAllReceipt);

		JButton btn_resetReceipt = new JButton("Làm mới");
		btn_resetReceipt.addActionListener(adminReceiptController);
		btn_resetReceipt.setBackground(new Color(149, 92, 211));
		btn_resetReceipt.setBounds(526, 15, 85, 21);
		panel_4_1.add(btn_resetReceipt);

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

		textField_cateFind = new JTextField();
		textField_cateFind.setColumns(10);
		textField_cateFind.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cateFind.setBackground(Color.WHITE);
		textField_cateFind.setBounds(98, 16, 347, 19);
		panel_5_4_1.add(textField_cateFind);

		JLabel lblNewLabel_8_4_1 = new JLabel("Tìm kiếm");
		lblNewLabel_8_4_1.setBounds(43, 19, 45, 13);
		panel_5_4_1.add(lblNewLabel_8_4_1);

		JButton btn_cateFind = new JButton("Tìm");
		btn_cateFind.addActionListener(adminCategoryController);
		btn_cateFind.setBackground(new Color(149, 92, 211));
		btn_cateFind.setBounds(455, 15, 85, 21);
		panel_5_4_1.add(btn_cateFind);

		JPanel product_infor_1_1 = new JPanel();
		product_infor_1_1.setLayout(null);
		product_infor_1_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null), "Th\u00F4ng tin danh m\u1EE5c",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		product_infor_1_1.setBounds(0, 50, 842, 112);
		panel_category.add(product_infor_1_1);

		JLabel lblNewLabel_9_4_1 = new JLabel("Mã danh mục:");
		lblNewLabel_9_4_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_4_1.setBounds(53, 29, 91, 13);
		product_infor_1_1.add(lblNewLabel_9_4_1);

		JLabel lblNewLabel_9_1_2_1 = new JLabel("Tên danh mục:");
		lblNewLabel_9_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_1_2_1.setBounds(53, 71, 91, 13);
		product_infor_1_1.add(lblNewLabel_9_1_2_1);

		textField_cateId = new JTextField();
		textField_cateId.setEditable(false);
		textField_cateId.setColumns(10);
		textField_cateId.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cateId.setBounds(140, 27, 126, 19);
		product_infor_1_1.add(textField_cateId);

		JLabel lblNewLabel_9_2_2_1_2 = new JLabel("Mô tả:");
		lblNewLabel_9_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_2_2_1_2.setBounds(348, 29, 45, 13);
		product_infor_1_1.add(lblNewLabel_9_2_2_1_2);

		textField_cateDescription = new JTextField();
		textField_cateDescription.setColumns(10);
		textField_cateDescription.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cateDescription.setBounds(403, 26, 347, 19);
		product_infor_1_1.add(textField_cateDescription);

		textField_cateName = new JTextField();
		textField_cateName.setColumns(10);
		textField_cateName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(149, 92, 211), null));
		textField_cateName.setBounds(140, 68, 126, 19);
		product_infor_1_1.add(textField_cateName);

		JPanel panel_3_4_2 = new JPanel();
		panel_3_4_2.setLayout(null);
		panel_3_4_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Danh s\u00E1ch danh m\u1EE5c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3_4_2.setBounds(0, 161, 842, 338);
		panel_category.add(panel_3_4_2);

		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 21, 822, 307);
		panel_3_4_2.add(scrollPane_6);

		table_category = new JTable();
		table_category.addMouseListener(adminCategoryController);
		table_category.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_category.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 danh m\u1EE5c", "T\u00EAn danh m\u1EE5c", "M\u00F4 t\u1EA3" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

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
		btn_addCategory.addActionListener(adminCategoryController);
		btn_addCategory.setBackground(new Color(149, 92, 211));
		btn_addCategory.setBounds(188, 15, 85, 21);
		panel_4_1_1.add(btn_addCategory);

		JButton btn_updateCategory = new JButton("Lưu");
		btn_updateCategory.addActionListener(adminCategoryController);
		btn_updateCategory.setBackground(new Color(149, 92, 211));
		btn_updateCategory.setBounds(283, 15, 85, 21);
		panel_4_1_1.add(btn_updateCategory);

		JButton btn_deleteCategory = new JButton("Xóa");
		btn_deleteCategory.addActionListener(adminCategoryController);
		btn_deleteCategory.setBackground(new Color(149, 92, 211));
		btn_deleteCategory.setBounds(378, 15, 85, 21);
		panel_4_1_1.add(btn_deleteCategory);

		JButton btn_deleteAllCategory = new JButton("Xóa tất cả");
		btn_deleteAllCategory.addActionListener(adminCategoryController);
		btn_deleteAllCategory.setBackground(new Color(149, 92, 211));
		btn_deleteAllCategory.setBounds(473, 15, 85, 21);
		panel_4_1_1.add(btn_deleteAllCategory);

		JButton btn_resetCategory = new JButton("Làm mới");
		btn_resetCategory.addActionListener(adminCategoryController);
		btn_resetCategory.setBackground(new Color(149, 92, 211));
		btn_resetCategory.setBounds(568, 15, 85, 21);
		panel_4_1_1.add(btn_resetCategory);

		JPanel panel_analytics = new JPanel();
		panel_cards.add(panel_analytics, "panel_analytics");
		panel_analytics.setLayout(null);

		JPanel panel_5_4_1_1 = new JPanel();
		panel_5_4_1_1.setLayout(null);
		panel_5_4_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Ti\u00EAu ch\u00ED th\u1ED1ng k\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_5_4_1_1.setBounds(0, 41, 842, 63);
		panel_analytics.add(panel_5_4_1_1);

		toDateChooser = new JDateChooser();
		toDateChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		toDateChooser.addPropertyChangeListener("date", adminAnalyticsController);
		toDateChooser.setDateFormatString("yyyy-MM-dd");
		toDateChooser.getDateEditor().setEnabled(false);
		toDateChooser.setBounds(455, 23, 105, 21);
		panel_5_4_1_1.add(toDateChooser);

		JLabel lblNewLabel_9_4_1_1 = new JLabel("Từ ngày: ");
		lblNewLabel_9_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_4_1_1.setBounds(162, 23, 56, 13);
		panel_5_4_1_1.add(lblNewLabel_9_4_1_1);

		JLabel lblNewLabel_9_4_1_1_1 = new JLabel("Đến ngày: ");
		lblNewLabel_9_4_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_9_4_1_1_1.setBounds(389, 23, 56, 13);
		panel_5_4_1_1.add(lblNewLabel_9_4_1_1_1);

		fromDateChooser = new JDateChooser();
		fromDateChooser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fromDateChooser.addPropertyChangeListener("date", adminAnalyticsController);
		fromDateChooser.setDateFormatString("yyyy-MM-dd");
		fromDateChooser.getDateEditor().setEnabled(false);
		fromDateChooser.setBounds(231, 23, 105, 21);
		panel_5_4_1_1.add(fromDateChooser);

		panel_analytic = new JPanel();
		panel_analytic.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(149, 92, 211), null),
				"Danh s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_analytic.setBounds(0, 114, 842, 396);
		panel_analytics.add(panel_analytic);
		panel_analytic.setLayout(new CardLayout(0, 0));

		JPanel analyticCate = new JPanel();
		panel_analytic.add(analyticCate, "analyticCate");
		analyticCate.setLayout(null);

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 10, 810, 355);
		analyticCate.add(scrollPane_7);

		table_analyticCate = new JTable();
		table_analyticCate.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT",
				"T\u00EAn danh m\u1EE5c", "S\u1ED1 l\u01B0\u1EE3ng \u0111\u00E3 b\u00E1n", "T\u1ED5ng doanh thu" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_analyticCate.getColumnModel().getColumn(0).setResizable(false);
		table_analyticCate.getColumnModel().getColumn(0).setPreferredWidth(51);
		table_analyticCate.getColumnModel().getColumn(1).setResizable(false);
		table_analyticCate.getColumnModel().getColumn(1).setPreferredWidth(151);
		table_analyticCate.getColumnModel().getColumn(2).setResizable(false);
		table_analyticCate.getColumnModel().getColumn(2).setPreferredWidth(110);
		table_analyticCate.getColumnModel().getColumn(3).setResizable(false);
		table_analyticCate.getColumnModel().getColumn(3).setPreferredWidth(155);
		scrollPane_7.setViewportView(table_analyticCate);

		JPanel analyticProduct = new JPanel();
		panel_analytic.add(analyticProduct, "analyticProduct");
		analyticProduct.setLayout(null);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(10, 10, 810, 355);
		analyticProduct.add(scrollPane_8);

		table_analyticProduct = new JTable();
		table_analyticProduct
				.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "T\u00EAn s\u1EA3n ph\u1EA9m",
						"S\u1ED1 l\u01B0\u1EE3ng \u0111\u00E3 b\u00E1n", "T\u1ED5ng doanh thu" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table_analyticProduct.getColumnModel().getColumn(0).setResizable(false);
		table_analyticProduct.getColumnModel().getColumn(0).setPreferredWidth(45);
		table_analyticProduct.getColumnModel().getColumn(1).setResizable(false);
		table_analyticProduct.getColumnModel().getColumn(1).setPreferredWidth(216);
		table_analyticProduct.getColumnModel().getColumn(2).setResizable(false);
		table_analyticProduct.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_analyticProduct.getColumnModel().getColumn(3).setResizable(false);
		table_analyticProduct.getColumnModel().getColumn(3).setPreferredWidth(113);
		scrollPane_8.setViewportView(table_analyticProduct);

		JPanel analyticEmployee = new JPanel();
		analyticEmployee.setLayout(null);
		panel_analytic.add(analyticEmployee, "analyticEmployee");

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(10, 10, 810, 355);
		analyticEmployee.add(scrollPane_9);

		table_analyticEmployee = new JTable();
		table_analyticEmployee.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "STT", "T\u00EAn \u0111\u0103ng nh\u1EADp",
						"S\u1ED1 l\u01B0\u1EE3ng \u0111\u00E3 b\u00E1n", "T\u1ED5ng doanh thu" }) {
					boolean[] columnEditables = new boolean[] { false, false, false, false };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table_analyticEmployee.getColumnModel().getColumn(0).setResizable(false);
		table_analyticEmployee.getColumnModel().getColumn(0).setPreferredWidth(42);
		table_analyticEmployee.getColumnModel().getColumn(1).setResizable(false);
		table_analyticEmployee.getColumnModel().getColumn(1).setPreferredWidth(101);
		table_analyticEmployee.getColumnModel().getColumn(2).setResizable(false);
		table_analyticEmployee.getColumnModel().getColumn(2).setPreferredWidth(110);
		table_analyticEmployee.getColumnModel().getColumn(3).setResizable(false);
		table_analyticEmployee.getColumnModel().getColumn(3).setPreferredWidth(134);
		scrollPane_9.setViewportView(table_analyticEmployee);

		JButton btn_analyticCate = new JButton("Thống kê theo loại");
		btn_analyticCate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_analyticCate.setBounds(10, 10, 162, 21);
		panel_analytics.add(btn_analyticCate);
		btn_analyticCate.addMouseListener(adminAnalyticsController);
		btn_analyticCate.setName("analyticCate");
		btn_analyticCate.setBackground(new Color(149, 92, 211));

		JButton btn_analyticProduct = new JButton("Thống kê theo sản phẩm");
		btn_analyticProduct.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_analyticProduct.setBounds(182, 10, 162, 21);
		panel_analytics.add(btn_analyticProduct);
		btn_analyticProduct.addMouseListener(adminAnalyticsController);

		btn_analyticProduct.setName("analyticProduct");
		btn_analyticProduct.setBackground(new Color(149, 92, 211));

		JButton btn_analyticEmployee = new JButton("Thống kê theo nhân viên");
		btn_analyticEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_analyticEmployee.setBounds(354, 10, 162, 21);
		panel_analytics.add(btn_analyticEmployee);
		btn_analyticEmployee.addMouseListener(adminAnalyticsController);
		btn_analyticEmployee.setName("analyticEmployee");
		btn_analyticEmployee.setBackground(new Color(149, 92, 211));

		JButton btnShowChart = new JButton("Xem biểu đồ");
		btnShowChart.addActionListener(adminAnalyticsController);
		btnShowChart.setBounds(540, 513, 135, 27);
		panel_analytics.add(btnShowChart);

		JButton btnReportAnalytic = new JButton("Xuất thống kê");
		btnReportAnalytic.addActionListener(adminAnalyticsController);

		btnReportAnalytic.setBounds(685, 513, 135, 27);
		panel_analytics.add(btnReportAnalytic);

		JPanel panel_header = new JPanel();
		panel_header.setBackground(new Color(100, 98, 179));
		panel_header.setBounds(241, 0, 842, 71);
		contentPane.add(panel_header);
		panel_header.setLayout(null);

		lbl_header = new JLabel("Quản lý sản phẩm");
		lbl_header.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lbl_header.setBounds(21, 28, 271, 33);
		panel_header.add(lbl_header);

		JLabel lblNewLabel_7 = new JLabel("Administrator");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_7.setBounds(38, 0, 124, 21);
		panel_header.add(lblNewLabel_7);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 478, 842, 72);
		panel_orderList.add(panel_1);
		panel_1.setLayout(null);

		JButton btn_resetOrder = new JButton("Làm mới");
		btn_resetOrder.setBounds(336, 22, 77, 23);
		panel_1.add(btn_resetOrder);
		btn_resetOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_resetOrder.setBackground(new Color(149, 92, 211));
		
		JButton btn_deleteOrder = new JButton("Xóa");
		btn_deleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_deleteOrder.setBackground(new Color(149, 92, 211));
		btn_deleteOrder.setBounds(431, 22, 77, 23);
		panel_1.add(btn_deleteOrder);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(32, 19, 176, 2);
		panel_header.add(separator_1);

		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(10, 59, 300, 2);
		panel_header.add(separator_3_1);

		this.setVisible(true);

		// QT
		// ADMIN - Order
		OrderBUS.loadOrder(table_order);
		comboBox_orderMonth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object selectedMonth = comboBox_orderMonth.getSelectedItem();
				if (selectedMonth instanceof Integer) {
					int month = (int) selectedMonth;
					OrderBUS.findOrderFromMonth(table_order, month);
				}
			}
		});
		btn_resetOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderBUS.resetForm(table_order, txtNhpMn);
				txtNhpMn.setText("");
			}
		});
		btn_deleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OrderBUS.deleteOrder(table_order);
				txtNhpMn.setText("");
			}
		});
		btn_orderFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderBUS.findOrder(table_order, txtNhpMn);
			}
		});
		table_order.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					int selectedRow = table_order.getSelectedRow();
					if (selectedRow != -1) {
						Integer id = (Integer) table_order.getValueAt(selectedRow, 0);
						Integer total = (Integer) table_order.getValueAt(selectedRow, 4);
						OrderDetailUI frame = new OrderDetailUI(id, total);
						frame.setVisible(true);
					}
				}
			}
		});

		// ADMIN - Customer
		CustomerBUS.loadCustomer(table_customer);
		btn_cusFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerBUS.findCustomer(table_customer, txtFindCus);
			}
		});
		btn_deleteCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerBUS.deleteCustomer(table_customer, txtidCustomer, txtnameCustomer, txtaddressCustomer,
						txtphoneCustomer, txtpointCustomer);
			}
		});
		btn_updateCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerBUS.updateCustomer(table_customer, txtidCustomer, txtnameCustomer, txtaddressCustomer,
						txtphoneCustomer, txtpointCustomer);
				txtFindCus.setText("");
			}
		});
		btnReloadCus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerBUS.resetForm(table_customer, txtidCustomer, txtnameCustomer, txtaddressCustomer,
						txtphoneCustomer, txtpointCustomer);
				txtFindCus.setText("");
			}
		});
		table_customer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_customer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = table_customer.getSelectedRow();
				CustomerBUS.loadFormCustomer(table_customer, selectedRow, txtidCustomer, txtnameCustomer,
						txtphoneCustomer, txtaddressCustomer, txtpointCustomer);
			}
		});

		// ADMIN - Account
		AccountBUS.loadAccount(table_account);
		btn_addAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccountBUS.insertAccount(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc,
						txtFullNameAcc, cbbRoleAcc, txtPhoneAcc);
			}
		});
		btn_updateAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountBUS.updateAccount(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc,
						txtFullNameAcc, cbbRoleAcc, txtPhoneAcc);
			}
		});
		btn_deleteAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AccountBUS.deleteAccount(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc,
						txtFullNameAcc, cbbRoleAcc, txtPhoneAcc);
			}
		});
		btn_resetAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountBUS.resetForm(table_account, txtIdAcc, txtUsernameAcc, txtPasswordAcc, txtFullNameAcc,
						cbbRoleAcc, txtPhoneAcc);
				txtFindAcc.setText("");
			}
		});
		btn_accFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountBUS.findAccount(table_account, txtFindAcc);
			}
		});
		table_account.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_account.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = table_account.getSelectedRow();
				AccountBUS.loadFormAccount(table_account, selectedRow, txtIdAcc, txtUsernameAcc,
						txtPasswordAcc, txtFullNameAcc, cbbRoleAcc, txtPhoneAcc);
			}
		});
		// QT - End
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

	public void handleShowCart(JPanel panel) throws ParseException {
		CardLayout cardLayout = (CardLayout) this.panel_cards.getLayout();
		if (panel.getName().equals("productList")) {
			this.lbl_header.setText("Quản lý sản phẩm");
			cardLayout.show(panel_cards, "panel_productList");
			showListProductToTable(productService.findAll(1));

		} else if (panel.getName().equals("orderList")) {
			this.lbl_header.setText("Quản lý đơn hàng");
			cardLayout.show(panel_cards, "panel_orderList");

		} else if (panel.getName().equals("cusList")) {
			this.lbl_header.setText("Quản lý khách hàng");
			cardLayout.show(panel_cards, "panel_cusList");

		} else if (panel.getName().equals("accList")) {
			this.lbl_header.setText("Quản lý tài khoản");
			cardLayout.show(panel_cards, "panel_accList");

		} else if (panel.getName().equals("receipt")) {
			this.lbl_header.setText("Quản lý nhập hàng");
			cardLayout.show(panel_cards, "panel_receipt");
			handleShowReceiptToTable(receiptService.findAll(1));

		} else if (panel.getName().equals("category")) {
			this.lbl_header.setText("Quản lý danh mục");
			cardLayout.show(panel_cards, "panel_category");
			showListCateToTable(categoryService.findAll(1));

		} else if (panel.getName().equals("analytics")) {
			this.lbl_header.setText("Thống kê");
			statistics = statisticService.findByCategory(1);
			DefaultTableModel tableModel = (DefaultTableModel) table_analyticCate.getModel();
			showAnalyticCToTable(statistics, tableModel);
			cardLayout.show(panel_cards, "panel_analytics");
			setDateIsNull();
		}
	}

	public void handleShowCartAnalytics(JButton panel) throws ParseException {
		CardLayout cardLayout = (CardLayout) this.panel_analytic.getLayout();
		DefaultTableModel tableModel;
		if (panel.getName().equals("analyticCate")) {
			cardLayout.show(panel_analytic, "analyticCate");
			statistics = statisticService.findByCategory(1);
			tableModel = (DefaultTableModel) table_analyticCate.getModel();
			showAnalyticCToTable(statistics, tableModel);
			this.currentStatistic = 0;

		} else if (panel.getName().equals("analyticProduct")) {
			cardLayout.show(panel_analytic, "analyticProduct");
			statistics = statisticService.findByProduct(1);
			tableModel = (DefaultTableModel) table_analyticProduct.getModel();
			showAnalyticCToTable(statistics, tableModel);
			this.currentStatistic = 1;

		} else if (panel.getName().equals("analyticEmployee")) {
			cardLayout.show(panel_analytic, "analyticEmployee");
			statistics = statisticService.findByAccount(1);
			tableModel = (DefaultTableModel) table_analyticEmployee.getModel();
			showAnalyticCToTable(statistics, tableModel);
			this.currentStatistic = 2;
		}
		setDateIsNull();
	}

	private void setDateIsNull() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date nullDate = dateFormat.parse("0000-01-01");
		fromDateChooser.setDate(nullDate);
		toDateChooser.setDate(new Date());
	}

	public void showAnalyticCToTable(List<StatisticDTO> list, DefaultTableModel tableModel) {
		tableModel.setRowCount(0);
		if (list != null) {
			int i = 1;
			for (StatisticDTO dto : list) {
				tableModel.addRow(new Object[] { i, dto.getName(), dto.getTotalQty(), dto.getTotalPrice() });
				i++;
			}
		}
	}

	// Receipt
	public void addRowReceipt(ReceiptDTO dto) {
		DefaultTableModel tableModel = (DefaultTableModel) table_receipt.getModel();
		tableModel.addRow(new Object[] { dto.getId(), dto.getAccountId(), dto.getSupplierId(), dto.getTotalPrice(),
				dto.getCreatedDate() });
	}

	public void handleShowReceiptToTable(List<ReceiptDTO> list) {
		DefaultTableModel tableModel = (DefaultTableModel) table_receipt.getModel();
		tableModel.setRowCount(0);
		if (list != null) {
			for (ReceiptDTO dto : list) {
				addRowReceipt(dto);
			}
		}

	}

	public void showReceiptToCpn(int row) {
		DefaultTableModel tableModel = (DefaultTableModel) table_receipt.getModel();
		String id = tableModel.getValueAt(row, 0).toString();
		String accId = tableModel.getValueAt(row, 1).toString();
		int supplId = (int) tableModel.getValueAt(row, 2);
		String amount = tableModel.getValueAt(row, 3).toString();
		String createdDate = tableModel.getValueAt(row, 4).toString();

		textField_receiptId.setText(id);
		textField_receiptAccId.setText(accId);
		textField_receiptTotalPrice.setText(amount);
		textField_receiptDate.setText(createdDate);
		comboBox_receiptSuppId.setSelectedItem(supplId);
	}

	public void formCleanReceipt() {
		textField_receiptFind.setText("");
		textField_receiptId.setText("");
		textField_receiptAccId.setText("");
		textField_receiptTotalPrice.setText("");
		textField_receiptDate.setText("");
		comboBox_receiptSuppId.setSelectedIndex(0);
	}

	public void handleFormCleanReceipt() {
		formCleanReceipt();
		handleShowReceiptToTable(receiptService.findAll(1));
	}

	// Product
	public void formClearProd() {
		this.textfiel_proFind.setText("");
		this.textField_proId.setText("");
		this.textField_proName.setText("");
		this.textField_proPrice.setText("");
		this.textField_proQuantity.setText("");
		this.comboBox_prodCateId.setSelectedIndex(0);
		this.lbl_image.setIcon(null);
	}

	public void handleFormCleanProd() {
		this.formClearProd();
		this.showListProductToTable(productService.findAll(1));
	}

	public void addRowProduct(ProductDTO product) {
		DefaultTableModel tableProdModel = (DefaultTableModel) this.table_product.getModel();
		tableProdModel
				.addRow(new Object[] { product.getId(), product.getName(), product.getPrice(), product.getQuantity(),
						categoryService.finById(product.getCategoryId()).getName(), product.getImage() });
	}

	public void showListProductToTable(List<ProductDTO> list) {
		DefaultTableModel tableProdModel = (DefaultTableModel) this.table_product.getModel();
		tableProdModel.setRowCount(0);
		if (list != null) {
			for (ProductDTO product : list) {
				this.addRowProduct(product);
			}
		}
	}

	public void showProdDataToComponents(int row) {
		DefaultTableModel tableProdModel = (DefaultTableModel) this.table_product.getModel();
		String id = tableProdModel.getValueAt(row, 0) + "";
		String name = tableProdModel.getValueAt(row, 1) + "";
		String price = tableProdModel.getValueAt(row, 2) + "";
		String quantity = tableProdModel.getValueAt(row, 3) + "";
		String cateName = tableProdModel.getValueAt(row, 4) + "";
		String imgPath = tableProdModel.getValueAt(row, 5) + "";

		this.textField_proId.setText(id);
		this.textField_proName.setText(name);
		this.textField_proPrice.setText(price);
		this.textField_proQuantity.setText(quantity);
		this.comboBox_prodCateId.setSelectedItem(cateName);
		ImageUtil.scaleImage(imgPath, lbl_image);
	}

	// Category
	public void showCateDataToComponents(int row) {
		DefaultTableModel tableProdModel = (DefaultTableModel) this.table_category.getModel();
		String id = tableProdModel.getValueAt(row, 0) + "";
		String name = tableProdModel.getValueAt(row, 1) + "";
		String description = tableProdModel.getValueAt(row, 2) + "";

		this.textField_cateId.setText(id);
		this.textField_cateName.setText(name);
		this.textField_cateDescription.setText(description);
	}

	public void addRowCategory(CategoryDTO category) {
		DefaultTableModel tableProdModel = (DefaultTableModel) this.table_category.getModel();
		tableProdModel.addRow(new Object[] { category.getId(), category.getName(), category.getDescription() });
	}

	public void showListCateToTable(List<CategoryDTO> list) {
		DefaultTableModel tableProdModel = (DefaultTableModel) this.table_category.getModel();
		tableProdModel.setRowCount(0);
		if (list != null) {
			for (CategoryDTO category : list) {
				this.addRowCategory(category);
			}
		}
	}

	public void formCleanCate() {
		this.textField_cateFind.setText("");
		this.textField_cateId.setText("");
		this.textField_cateName.setText("");
		this.textField_cateDescription.setText("");
	}

	public void handleFormCleanCate() {
		this.formCleanCate();
		this.showListCateToTable(categoryService.findAll(1));
	}
}
