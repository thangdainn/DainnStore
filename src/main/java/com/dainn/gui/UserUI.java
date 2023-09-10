package com.dainn.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPanel panel_3;
	private JTextField tF_quantity;

	
	public UserUI() {
		setSize(1097, 657);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(0, 0, 190, 620);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Dainn Store");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setFont(new Font("Segoe Print", Font.BOLD, 24));
		lblNewLabel_5.setBounds(10, 23, 169, 47);
		panel.add(lblNewLabel_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 80, 169, 15);
		panel.add(separator);
		
		JPanel btn_iPhone = new JPanel();
		btn_iPhone.setLayout(null);
		btn_iPhone.setName("productList");
		btn_iPhone.setForeground(Color.BLACK);
		btn_iPhone.setBackground(new Color(123, 54, 199));
		btn_iPhone.setBounds(32, 189, 124, 47);
		panel.add(btn_iPhone);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 7, 33, 33);
		lblNewLabel_2.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-iphone-30.png")));
		btn_iPhone.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("iPhone");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1.setForeground(new Color(102, 204, 255));
		lblNewLabel_1_1_1_1.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1.setBounds(47, 7, 77, 33);
		btn_iPhone.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(10, 3, 40, 40);
		btn_iPhone.add(lblNewLabel_2_1_1);
		
		JPanel btn_iPad = new JPanel();
		btn_iPad.setLayout(null);
		btn_iPad.setName("productList");
		btn_iPad.setForeground(Color.BLACK);
		btn_iPad.setBackground(new Color(123, 54, 199));
		btn_iPad.setBounds(32, 246, 125, 47);
		panel.add(btn_iPad);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setBounds(10, 7, 33, 33);
		lblNewLabel_2_1.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-ipad-30.png")));
		btn_iPad.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("iPad");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(102, 204, 255));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_1.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1_1.setBounds(48, 7, 77, 33);
		btn_iPad.add(lblNewLabel_1_1_1_1_1);
		
		JPanel btn_macbook = new JPanel();
		btn_macbook.setLayout(null);
		btn_macbook.setName("productList");
		btn_macbook.setForeground(Color.BLACK);
		btn_macbook.setBackground(new Color(123, 54, 199));
		btn_macbook.setBounds(32, 303, 125, 47);
		panel.add(btn_macbook);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBackground(Color.WHITE);
		lblNewLabel_2_2.setBounds(10, 7, 33, 33);
		lblNewLabel_2_2.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-macbook-30.png")));
		btn_macbook.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Mac");
		lblNewLabel_1_1_1_1_2.setForeground(new Color(102, 204, 255));
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_2.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1_2.setBounds(48, 7, 77, 33);
		btn_macbook.add(lblNewLabel_1_1_1_1_2);
		
		JPanel btn_watch = new JPanel();
		btn_watch.setLayout(null);
		btn_watch.setName("productList");
		btn_watch.setForeground(Color.BLACK);
		btn_watch.setBackground(new Color(123, 54, 199));
		btn_watch.setBounds(33, 360, 125, 47);
		panel.add(btn_watch);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setBackground(Color.WHITE);
		lblNewLabel_2_3.setBounds(10, 7, 33, 33);
		lblNewLabel_2_3.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-apple-watch-30.png")));
		btn_watch.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Watch");
		lblNewLabel_1_1_1_1_3.setForeground(new Color(102, 204, 255));
		lblNewLabel_1_1_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_3.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1_3.setBounds(48, 7, 77, 33);
		btn_watch.add(lblNewLabel_1_1_1_1_3);
		
		JPanel btn_airPods = new JPanel();
		btn_airPods.setLayout(null);
		btn_airPods.setName("productList");
		btn_airPods.setForeground(Color.BLACK);
		btn_airPods.setBackground(new Color(123, 54, 199));
		btn_airPods.setBounds(32, 417, 125, 47);
		panel.add(btn_airPods);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setBackground(Color.WHITE);
		lblNewLabel_2_4.setBounds(10, 7, 33, 33);
		lblNewLabel_2_4.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-airpods-30.png")));
		btn_airPods.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_1_1_1_1_4 = new JLabel("AirPods");
		lblNewLabel_1_1_1_1_4.setForeground(new Color(102, 204, 255));
		lblNewLabel_1_1_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_4.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1_4.setBounds(48, 7, 77, 33);
		btn_airPods.add(lblNewLabel_1_1_1_1_4);
		
		JLabel btn_logOut = new JLabel("");
		btn_logOut.setBounds(10, 563, 45, 45);
		btn_logOut.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-log-in-42.png")));
		btn_logOut.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new LoginUI();
            }
		});
		panel.add(btn_logOut);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 474, 137, 15);
		panel.add(separator_1);
		
		JPanel btn_receipt = new JPanel();
		btn_receipt.setLayout(null);
		btn_receipt.setName("productList");
		btn_receipt.setForeground(Color.BLACK);
		btn_receipt.setBackground(new Color(0, 102, 0));
		btn_receipt.setBounds(0, 499, 137, 42);
		panel.add(btn_receipt);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setBackground(Color.WHITE);
		lblNewLabel_2_5.setBounds(10, 4, 33, 33);
		lblNewLabel_2_5.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-add-to-basket-30.png")));
		btn_receipt.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_1_1_1_1_5 = new JLabel("Nhập hàng");
		lblNewLabel_1_1_1_1_5.setForeground(new Color(102, 204, 255));
		lblNewLabel_1_1_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_5.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1_5.setBounds(47, 4, 90, 33);
		btn_receipt.add(lblNewLabel_1_1_1_1_5);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_1.setBounds(10, 3, 40, 40);
		btn_receipt.add(lblNewLabel_2_1_1_1);
		
		JPanel btn_iPhone_1 = new JPanel();
		btn_iPhone_1.setLayout(null);
		btn_iPhone_1.setName("productList");
		btn_iPhone_1.setForeground(Color.BLACK);
		btn_iPhone_1.setBackground(new Color(123, 54, 199));
		btn_iPhone_1.setBounds(32, 132, 124, 47);
		panel.add(btn_iPhone_1);
		
		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setBackground(Color.WHITE);
		lblNewLabel_2_6.setBounds(10, 7, 33, 33);
		lblNewLabel_2_6.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-apple-30.png")));
		btn_iPhone_1.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_1_1_1_1_6 = new JLabel("Tất cả");
		lblNewLabel_1_1_1_1_6.setForeground(new Color(102, 204, 255));
		lblNewLabel_1_1_1_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1_1_1_6.setBackground(new Color(143, 88, 199));
		lblNewLabel_1_1_1_1_6.setBounds(47, 7, 77, 33);
		btn_iPhone_1.add(lblNewLabel_1_1_1_1_6);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("");
		lblNewLabel_2_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_2_1_1_2.setBounds(10, 3, 40, 40);
		btn_iPhone_1.add(lblNewLabel_2_1_1_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(190, 0, 893, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Đào Đức Thắng");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(684, 14, 125, 25);
		panel_1.add(lblNewLabel);
		
		JLabel cart = new JLabel("");
		cart.setHorizontalAlignment(SwingConstants.CENTER);
		cart.setBounds(807, 4, 63, 45);
		cart.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-cart-42.png")));
		panel_1.add(cart);
		
		JLabel lblNewLabel_1 = new JLabel("IPhone");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 26));
		lblNewLabel_1.setBounds(36, 4, 167, 45);
		panel_1.add(lblNewLabel_1);
		
		JLabel cart_1 = new JLabel("");
		cart_1.setHorizontalAlignment(SwingConstants.CENTER);
		cart_1.setBounds(635, 4, 45, 45);
		cart_1.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-account-30.png")));
		panel_1.add(cart_1);
		
		textField = new JTextField();
		textField.setBounds(172, 12, 311, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(493, 11, 30, 30);
		btnNewButton_1.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-search-24.png")));
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(190, 52, 893, 568);
		contentPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel card_product = new JPanel();
		panel_2.add(card_product, "name_349270714058800");
		card_product.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 0, 893, 39);
		card_product.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Từ:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_6.setBounds(569, 5, 23, 29);
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Đến:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(691, 5, 29, 29);
		panel_4.add(lblNewLabel_7);
		
		textField_1 = new JTextField();
		textField_1.setBounds(591, 10, 90, 19);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(720, 10, 90, 19);
		panel_4.add(textField_2);
		
		JLabel lblNewLabel_4 = new JLabel("Lọc theo giá:");
		lblNewLabel_4.setForeground(new Color(0, 102, 102));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(481, 7, 78, 24);
		panel_4.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(820, 6, 26, 26);
		btnNewButton.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-filter-24.png")));
		panel_4.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 893, 531);
		card_product.add(scrollPane);
		
		panel_3 = new JPanel();
		scrollPane.setViewportView(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(null);
		FlowLayout flowLayout_1 = (FlowLayout) panel_6.getLayout();
		flowLayout_1.setHgap(10);
		panel_3.add(panel_6, BorderLayout.WEST);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setHgap(10);
		panel_3.add(panel_7, BorderLayout.EAST);
		
		JPanel panel_8 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_8.getLayout();
		flowLayout_2.setVgap(10);
		panel_3.add(panel_8, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.SOUTH);
		
		this.addPanelProduct(panel_3, 3);
		
		JPanel panel_receipt = new JPanel();
		panel_2.add(panel_receipt, "name_349277620621800");
		panel_receipt.setLayout(null);

		this.setVisible(true);
	}
	
	public void addPanelProduct(JPanel Panel, int length) {
		int row;
		if (length / 5 <= 2) {
			row = 3;
		} else if (length % 5 != 0) {
			row = length / 5 + 1;
		} else {
			row = length / 5;
		}
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(240, 240, 240));
		Panel.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(row, 5, 22, 20));
		int countEmptyPanel = 0;
		if (row == 3 && length < 13){
			countEmptyPanel = 13 - length;
		}

		for (int i = 1; i <= length; i++) {
			panel_5.add(createPanelProduct());
        }
		for (int i = 1; i <= countEmptyPanel; i++) {
			panel_5.add(emptyPanelProduct());
		}
	}
	
	public JPanel createPanelProduct() {
		JPanel panel_3_3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_3_3.setBackground(new Color(255, 255, 255));
		panel_3_3.setPreferredSize(new Dimension(149, 190));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setPreferredSize(new Dimension(105, 105));
		panel_3_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_8 = new JLabel("iPhone 14 Pro Max");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setPreferredSize(new Dimension(129, 21));
		panel_3_3.add(lblNewLabel_8);

		JPanel pricePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		pricePanel.setBackground(Color.WHITE);

		JLabel lblNewLabel_8_1_1 = new JLabel("Giá:");
		lblNewLabel_8_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3_3.add(lblNewLabel_8_1_1);

		JLabel lblNewLabel_8_1 = new JLabel("24000000");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3_3.add(lblNewLabel_8_1);

		panel_3_3.add(pricePanel);

		JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
		actionPanel.setBackground(Color.WHITE);

		tF_quantity = new JTextField();
		tF_quantity.setHorizontalAlignment(SwingConstants.CENTER);
		tF_quantity.setPreferredSize(new Dimension(25, 23));
		actionPanel.add(tF_quantity);
		tF_quantity.setColumns(3);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_2.setPreferredSize(new Dimension(26, 25));
		btnNewButton_2.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-add-shopping-cart-22.png")));
		actionPanel.add(btnNewButton_2);

		panel_3_3.add(actionPanel);
		
		return panel_3_3;
	}

	public JPanel emptyPanelProduct(){
		JPanel emptyPanel = new JPanel();
		emptyPanel.setBackground(new Color(240, 240, 240));
		emptyPanel.setPreferredSize(new Dimension(149, 190));
		return emptyPanel;
	}
}
