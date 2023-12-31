package com.dainn.gui;

import com.dainn.controller.LoginController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {

	public JPanel contentPane;
	public JTextField tFLogin_username;
	public JPasswordField tFLogin_password;
	public JTextField tFSignUp_username;
	public JTextField tFSignUp_password;
	public JTextField tFSignUp_repassword;
	public JPanel panel_cards;
	public JButton btn_signup;

	public LoginUI() {
		this.init();
	}
	

	public void init() {
		setTitle("Đăng nhập");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(860, 540);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		LoginController controller = new LoginController(this);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 502, 503);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(new Rectangle(0, 0, 502, 503));
		lblNewLabel_3.setIcon(new ImageIcon(LoginUI.class.getResource("/icons/dainnn.png")));
		panel.add(lblNewLabel_3);

		panel_cards = new JPanel();
		panel_cards.setBounds(522, 0, 324, 503);
		contentPane.add(panel_cards);
		panel_cards.setLayout(new CardLayout(0, 0));

		JPanel panel_login = new JPanel();
		panel_login.setLayout(null);
		panel_login.setBackground(Color.WHITE);
		panel_cards.add(panel_login, "panel_login");

		JLabel lblNewLabel_4 = new JLabel("Tên đăng nhập");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(86, 190, 152, 21);
		panel_login.add(lblNewLabel_4);

		JLabel lblMtKhu_1 = new JLabel("Mật khẩu");
		lblMtKhu_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMtKhu_1.setBounds(86, 266, 152, 21);
		panel_login.add(lblMtKhu_1);

		tFLogin_username = new JTextField();
		tFLogin_username.setColumns(10);
		tFLogin_username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 54, 199)));
		tFLogin_username.setBackground(new Color(234, 234, 234));
		tFLogin_username.setBounds(86, 212, 152, 27);
		panel_login.add(tFLogin_username);

		tFLogin_password = new JPasswordField();
		tFLogin_password.setColumns(10);
		tFLogin_password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 54, 199)));
		tFLogin_password.setBackground(new Color(234, 234, 234));
		tFLogin_password.setBounds(86, 288, 152, 27);
		panel_login.add(tFLogin_password);

		JButton btn_login = new JButton("Đăng nhập");
		btn_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_login.addActionListener(controller);
		btn_login.addMouseListener(controller);
		btn_login.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btn_login.setBorderPainted(false);
		btn_login.setBackground(new Color(149, 92, 211));
		btn_login.setBounds(86, 325, 152, 27);
		panel_login.add(btn_login);

		JLabel lblNewLabel_1_1 = new JLabel("ĐĂNG NHẬP");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(123, 54, 199));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(78, 90, 167, 35);
		panel_login.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Hoặc:");
		lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 8));
		lblNewLabel_2_1.setBounds(112, 362, 31, 13);
		panel_login.add(lblNewLabel_2_1);

		JButton btnSub_signup = new JButton("Quên mật khẩu");
		btnSub_signup.setBorderPainted(false);
		btnSub_signup.setBackground(new Color(149, 92, 211));
		btnSub_signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSub_signup.addActionListener(controller);
		btnSub_signup.addMouseListener(controller);
		btnSub_signup.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSub_signup.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSub_signup.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSub_signup.setBounds(140, 362, 98, 16);
		panel_login.add(btnSub_signup);

		JPanel panel_signup = new JPanel();
		panel_signup.setLayout(null);
		panel_signup.setBackground(Color.WHITE);
		panel_cards.add(panel_signup, "panel_signup");

		JLabel lblNewLabel = new JLabel("Tên đăng nhập");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(86, 167, 152, 21);
		panel_signup.add(lblNewLabel);

		JLabel lblMtKhu = new JLabel("Mật khẩu mới");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMtKhu.setBounds(86, 237, 152, 21);
		panel_signup.add(lblMtKhu);

		tFSignUp_username = new JTextField();
		tFSignUp_username.setColumns(10);
		tFSignUp_username.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 54, 199)));
		tFSignUp_username.setBackground(new Color(234, 234, 234));
		tFSignUp_username.setBounds(86, 186, 152, 27);
		panel_signup.add(tFSignUp_username);

		tFSignUp_password = new JTextField();
		tFSignUp_password.setEditable(false);
		tFSignUp_password.setColumns(10);
		tFSignUp_password.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 54, 199)));
		tFSignUp_password.setBackground(new Color(234, 234, 234));
		tFSignUp_password.setBounds(86, 259, 152, 27);
		panel_signup.add(tFSignUp_password);

		btn_signup = new JButton("Xác nhận");
		btn_signup.setEnabled(false);
		btn_signup.setForeground(new Color(0, 0, 0));
		btn_signup.addActionListener(controller);
		btn_signup.addMouseListener(controller);
		btn_signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_signup.setFont(new Font("Segoe UI", Font.BOLD, 10));
		btn_signup.setBorderPainted(false);
		btn_signup.setBackground(new Color(149, 92, 211));
		btn_signup.setBounds(86, 365, 152, 27);
		panel_signup.add(btn_signup);

		JLabel lblNewLabel_1 = new JLabel("QUÊN MẬT KHẨU");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(123, 54, 199));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(70, 76, 183, 35);
		panel_signup.add(lblNewLabel_1);

		tFSignUp_repassword = new JTextField();
		tFSignUp_repassword.setEditable(false);
		tFSignUp_repassword.setColumns(10);
		tFSignUp_repassword.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(123, 54, 199)));
		tFSignUp_repassword.setBackground(new Color(234, 234, 234));
		tFSignUp_repassword.setBounds(86, 328, 152, 27);
		panel_signup.add(tFSignUp_repassword);

		JLabel lblNewLabel_4_1 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4_1.setBounds(86, 310, 152, 21);
		panel_signup.add(lblNewLabel_4_1);

		JButton btnSub_login = new JButton("Đăng nhập ngay");
		btnSub_login.setBackground(new Color(149, 92, 211));
		btnSub_login.setBorderPainted(false);
		btnSub_login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSub_login.addActionListener(controller);
		btnSub_login.addMouseListener(controller);
		btnSub_login.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSub_login.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSub_login.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnSub_login.setBounds(145, 402, 93, 16);
		panel_signup.add(btnSub_login);
		
		JButton btn_signupCheck = new JButton("Kiểm tra");
		btn_signupCheck.addActionListener(controller);
		btn_signupCheck.addMouseListener(controller);
		btn_signupCheck.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_signupCheck.setHorizontalTextPosition(SwingConstants.CENTER);
		btn_signupCheck.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btn_signupCheck.setBorderPainted(false);
		btn_signupCheck.setBackground(new Color(149, 92, 211));
		btn_signupCheck.setBounds(171, 223, 67, 16);
		panel_signup.add(btn_signupCheck);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Hoặc:");
		lblNewLabel_2_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 8));
		lblNewLabel_2_1_1.setBounds(115, 402, 31, 16);
		panel_signup.add(lblNewLabel_2_1_1);

		this.setVisible(true);
		
	}

	public void setColor(JButton btn) {
		btn.setBackground(new Color(176, 150, 216));
		btn.setForeground(new Color(255, 255, 255));
	}

	public void resetColor(JButton btn) {
		btn.setBackground(new Color(149, 92, 211));
		btn.setForeground(new Color(0, 0, 0));
	}

	public void showCard(String s) {
		CardLayout cardLayout = (CardLayout) this.panel_cards.getLayout();
		cardLayout.show(panel_cards, s);
	}
}
