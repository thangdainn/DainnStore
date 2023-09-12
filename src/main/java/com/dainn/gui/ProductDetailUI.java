package com.dainn.gui;

import com.dainn.dto.ColorDTO;
import com.dainn.dto.ProductDTO;
import com.dainn.service.IColorService;
import com.dainn.service.impl.ColorService;
import com.dainn.utils.ImageUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class ProductDetailUI extends JFrame {

	private IColorService colorService;
	private JPanel contentPane;
	private ProductDTO productDTO;
	private JComboBox comboBox_color;
	private List<ColorDTO> colors;

	public ProductDetailUI(ProductDTO productDTO){
		setResizable(false);
		this.colorService = new ColorService();
		this.productDTO = productDTO;
		this.colors = colorService.findAll();
		this.init();
		this.setVisible(true);
	}

	public void init() {
		setTitle("Chi tiết sản phẩm");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(420, 598);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(18, 10, 369, 355);
		ImageUtil.scaleImage(productDTO.getImage(), lblNewLabel);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá: " + productDTO.getPrice());
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(204, 428, 146, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel(productDTO.getName());
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(73, 389, 260, 29);
		contentPane.add(lblNewLabel_2);
		
		comboBox_color = new JComboBox();
		comboBox_color.addItem("Chọn màu");
		for (ColorDTO color : this.colors){
			comboBox_color.addItem(color.getName());
		}
		comboBox_color.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox_color.setBounds(105, 430, 89, 27);
		
		contentPane.add(comboBox_color);
		
		JButton btn_addToCart = new JButton("Thêm vào giỏ hàng");
		btn_addToCart.setBorderPainted(false);
		btn_addToCart.setBackground(new Color(153, 51, 255));
		btn_addToCart.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btn_addToCart.setBounds(83, 481, 250, 49);
		contentPane.add(btn_addToCart);
	}
}