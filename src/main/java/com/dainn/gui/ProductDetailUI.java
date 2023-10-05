package com.dainn.gui;

import com.dainn.controller.user.UserProductDetailController;
import com.dainn.dto.RomDTO;
import com.dainn.dto.ProductDTO;
import com.dainn.service.IRomService;
import com.dainn.service.impl.RomService;
import com.dainn.utils.ImageUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class ProductDetailUI extends JFrame {

	private IRomService romservice;
	private JPanel contentPane;
	private ProductDTO productDTO;
	public JComboBox comboBox_rom;
	private List<RomDTO> roms;
	public JLabel lbl_price;

	public ProductDetailUI(ProductDTO productDTO){
		setResizable(false);
		this.romservice = new RomService();
		this.productDTO = productDTO;
		this.roms = romservice.findByProduct_Id(productDTO.getId());
		this.init();
		this.setVisible(true);
	}

	public void init() {
		setTitle("Chi tiết sản phẩm");
		setSize(420, 598);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		UserProductDetailController controller = new UserProductDetailController(this, roms, productDTO);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(18, 10, 369, 355);
		ImageUtil.scaleImage(productDTO.getImage(), lblNewLabel);
		contentPane.add(lblNewLabel);
		
		lbl_price = new JLabel(productDTO.getPrice() + "");
		lbl_price.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_price.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbl_price.setBounds(214, 428, 89, 29);
		contentPane.add(lbl_price);
		
		JLabel lblNewLabel_2 = new JLabel(productDTO.getName());
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(73, 389, 260, 29);
		contentPane.add(lblNewLabel_2);
		
		comboBox_rom = new JComboBox();
		for (RomDTO color : this.roms){
			comboBox_rom.addItem(color.getCapacity());
		}
		comboBox_rom.addActionListener(controller);
		comboBox_rom.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboBox_rom.setBounds(94, 428, 71, 29);
		
		contentPane.add(comboBox_rom);
		
		JButton btn_addToCart = new JButton("Thêm vào giỏ hàng");
		btn_addToCart.setBorderPainted(false);
		btn_addToCart.addMouseListener(controller);
		btn_addToCart.addActionListener(controller);
		btn_addToCart.setBackground(new Color(153, 51, 255));
		btn_addToCart.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btn_addToCart.setBounds(83, 481, 250, 49);
		contentPane.add(btn_addToCart);
		
		JLabel lblNewLabel_1 = new JLabel("đ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(305, 428, 32, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Giá: ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(175, 428, 40, 29);
		contentPane.add(lblNewLabel_1_1);
	}
}
