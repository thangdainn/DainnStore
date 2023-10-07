package com.dainn.gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class TestCart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestCart frame = new TestCart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestCart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 588);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_product = new JPanel();
		panel_product.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_product.setBounds(341, 386, 477, 119);
		contentPane.add(panel_product);
		
		JLabel img = new JLabel("");
		img.setBackground(new Color(255, 128, 0));
		img.setForeground(new Color(140, 171, 181));
		img.setHorizontalAlignment(SwingConstants.CENTER);
		img.setPreferredSize(new Dimension(95, 95));
		img.setSize(new Dimension(87, 87));
		panel_product.add(img);
		
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(360, 100));
		panel_product.add(panel_2);
		
		JLabel productName = new JLabel("New label");
		productName.setBackground(new Color(128, 128, 128));
		panel_2.add(productName);
		productName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		productName.setHorizontalAlignment(SwingConstants.LEFT);
		productName.setPreferredSize(new Dimension(354, 24));
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(360, 30));
		panel_2.add(panel_3);
		
		JLabel lblpricee = new JLabel("Đơn giá:");
		panel_3.add(lblpricee);
		lblpricee.setPreferredSize(new Dimension(46, 24));
		lblpricee.setHorizontalAlignment(SwingConstants.LEFT);
		lblpricee.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel price = new JLabel("20000000đ");
		price.setPreferredSize(new Dimension(55, 24));
		price.setHorizontalAlignment(SwingConstants.LEFT);
		price.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_3.add(price);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("");
		lblNewLabel_1_1_1_2_1.setPreferredSize(new Dimension(20, 24));
		lblNewLabel_1_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_3.add(lblNewLabel_1_1_1_2_1);
		
		JLabel romName = new JLabel("Rom: 256GB");
		romName.setPreferredSize(new Dimension(219, 24));
		romName.setHorizontalAlignment(SwingConstants.LEFT);
		romName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_3.add(romName);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setPreferredSize(new Dimension(360, 30));
		panel_2.add(panel_3_1);
		
		JButton btnMinus = new JButton("");
		btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinus.setPreferredSize(new Dimension(24, 24));
		btnMinus.setSize(24, 24);
		btnMinus.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-minus-18.png")));
		panel_3_1.add(btnMinus);
		
		JTextField tF_quantity = new JTextField("");
		tF_quantity.setPreferredSize(new Dimension(24, 24));
		tF_quantity.setHorizontalAlignment(SwingConstants.CENTER);
		tF_quantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_3_1.add(tF_quantity);
		
		JButton btnAdd = new JButton("");
		btnAdd.setPreferredSize(new Dimension(24, 24));
		btnAdd.setSize(24, 24);
		btnAdd.setIcon(new ImageIcon(AdminUI.class.getResource("/icons/icons8-add-18.png")));
		panel_3_1.add(btnAdd);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setPreferredSize(new Dimension(200, 24));
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_3_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnDelete = new JButton("Xóa");
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnDelete.setPreferredSize(new Dimension(53, 24));
		panel_3_1.add(btnDelete);
	}

}
