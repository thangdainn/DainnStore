package com.dainn.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class UserUI extends JFrame {

	private JPanel contentPane;

	
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
		
		JLabel lblNewLabel_5 = new JLabel("Dainn Phone");
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
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(190, 63, 893, 557);
		contentPane.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, "name_349270714058800");
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, "name_349277620621800");
		panel_4.setLayout(null);

		this.setVisible(true);
	}
}
