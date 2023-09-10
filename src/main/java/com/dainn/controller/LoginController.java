package com.dainn.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import com.dainn.service.IAccountService;
import com.dainn.service.impl.AccountService;
import com.dainn.dto.AccountDTO;
import com.dainn.gui.AdminUI;
import com.dainn.gui.LoginUI;
import com.dainn.gui.UserUI;

public class LoginController implements ActionListener, MouseListener {
    private LoginUI loginUI;
    private IAccountService accountService;

    public LoginController(LoginUI loginUI) {
        this.loginUI = loginUI;
        this.accountService = new AccountService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Đăng nhập")) {
            handleLogin();
        } else if (btn.equals("Đăng ký")) {
            handleSignUp();
        } else if (btn.equals("Tạo tài khoản")) {
            loginUI.showCard("panel_signup");
        } else if (btn.equals("Đăng nhập ngay")) {
            loginUI.showCard("panel_login");
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {


    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        loginUI.setColor(btn);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        loginUI.resetColor(btn);
    }

    public void handleLogin() {
        String username = loginUI.tFLogin_username.getText().trim();
        String password = loginUI.tFLogin_password.getText().trim();
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginUI, "Vui lòng điền đầy đủ thông tin!");
        } else {
            AccountDTO accountDTO = accountService.findByUserNameAndPasswordAndStatus(username, password, 1);
            if (accountDTO != null) {
                if (accountDTO.getRoleId().equals("ADMIN")) {
                    loginUI.setVisible(false);
					new AdminUI(accountDTO);
                } else if (accountDTO.getRoleId().equals("USER")) {
                    loginUI.setVisible(false);
					new UserUI();
                }
            } else {
                JOptionPane.showMessageDialog(loginUI, "Thông tin đăng nhập không chính xác.");
            }
        }
    }

    public void handleSignUp() {
        String username = loginUI.tFSignUp_username.getText().trim();
        String fullName = loginUI.tFSignUp_fullName.getText().trim();
        String phone = loginUI.tFSignUp_phone.getText().trim();
        String address = loginUI.tFSignUp_address.getText().trim();
        String password = loginUI.tFSignUp_password.getText().trim();
        String rePassword = loginUI.tFSignUp_repassword.getText().trim();
        String regex = "^[0-9]\\d*$";
        if (username.isEmpty() || password.isEmpty() || fullName.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(loginUI, "Vui lòng điền đầy đủ thông tin!");
        } else if (!phone.matches(regex) || phone.length() > 10){
            JOptionPane.showMessageDialog(loginUI, "Số điện thoại không hợp lệ.");
        } else if (rePassword.equals(password)) {
            AccountDTO accountDTO = accountService.findByUserName(username);
            if (accountDTO == null) {
                accountDTO = new AccountDTO();
                accountDTO.setUsername(username);
                accountDTO.setFullName(fullName);
                accountDTO.setPhone(phone);
                accountDTO.setAddress(address);
                accountDTO.setPassword(password);
                accountDTO.setStatus(1);
                accountDTO.setRoleId("USER");
                accountService.save(accountDTO);
                JOptionPane.showMessageDialog(loginUI, "Tạo tài khoản thành công.");
                loginUI.showCard("panel_login");
            } else {
                JOptionPane.showMessageDialog(loginUI, "Tên đăng nhập đẫ tồn tại.");
            }
        } else {
            JOptionPane.showMessageDialog(loginUI, "Mật khẩu không khớp.");
        }

    }
}

