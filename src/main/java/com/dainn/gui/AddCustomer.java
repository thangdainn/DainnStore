package com.dainn.gui;

import com.dainn.dto.CustomerDTO;
import com.dainn.service.ICustomerService;
import com.dainn.service.impl.CustomerService;
import com.dainn.utils.NumberTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomer extends JFrame {

	private ICustomerService customerService = new CustomerService();
	private JFrame frame;
	private JPanel contentPane;
	private JTextField tF_name;
	private JTextField tF_address;
	private JTextField tF_phone;

	public AddCustomer(){
		this.frame = this;
		this.init();
	}

	public void init() {
		setTitle("Thêm khách hàng");
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(420, 598);
        setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 128, 128));
		panel.setBounds(0, 0, 406, 106);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thêm khách hàng");
		lblNewLabel.setForeground(new Color(177, 177, 177));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 25, 249, 55);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Họ và tên:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(49, 215, 93, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Địa chỉ:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(49, 287, 93, 36);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số điện thoại:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(49, 352, 110, 36);
		contentPane.add(lblNewLabel_1_2);
		
		tF_name = new JTextField();
		tF_name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_name.setBounds(163, 216, 180, 35);
		contentPane.add(tF_name);
		tF_name.setColumns(10);
		
		tF_address = new JTextField();
		tF_address.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_address.setColumns(10);
		tF_address.setBounds(163, 288, 180, 36);
		contentPane.add(tF_address);
		
		tF_phone = new JTextField();
		tF_phone.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		tF_phone.setColumns(10);
		tF_phone.setBounds(163, 353, 180, 36);
		NumberTextField.numberTextField(tF_phone);
		contentPane.add(tF_phone);
		
		JButton btnApply = new JButton("Xác nhận");
		btnApply.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnApply.setForeground(new Color(192, 192, 192));
		btnApply.setBorderPainted(false);
		btnApply.setBackground(new Color(0, 128, 128));
		btnApply.setFont(new Font("Times New Roman", Font.BOLD, 24));
		btnApply.setBounds(85, 439, 244, 59);
		btnApply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CustomerDTO customerDTO = getDataFromComponents();
				if (customerDTO != null){
					customerDTO = customerService.save(customerDTO);
					if (customerDTO.getId() != null){
						JOptionPane.showMessageDialog(frame, "Thêm khách hàng thành công!!!");
						frame.dispose();
					}
				}

			}
		});
		contentPane.add(btnApply);

		setVisible(true);
	}

	private CustomerDTO getDataFromComponents(){
		String fullName = tF_name.getText().trim();
		String address = tF_address.getText().trim();
		String phone = tF_phone.getText().trim();
		if (!fullName.equals("") && !address.equals("") && !phone.equals("")){
			CustomerDTO customer = customerService.findByPhone(phone, 1);
			if (customer == null){
				customer = new CustomerDTO();
				customer.setName(fullName);
				customer.setAddress(address);
				customer.setPhone(phone);
				return customer;
			}
			JOptionPane.showMessageDialog(frame, "Số điện thoại đã tồn tại!!!");
			return null;
		} else {
			JOptionPane.showMessageDialog(frame, "Vui lòng điền đủ thông tin!!!");
			return null;
		}
	}
}
