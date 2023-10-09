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
    private AccountDTO account = null;

    public LoginController(LoginUI loginUI) {
        this.loginUI = loginUI;
        this.accountService = new AccountService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Đăng nhập")) {
            handleLogin();
        } else if (btn.equals("Kiểm tra")) {
            checkAccount(loginUI.tFSignUp_username.getText());
        } else if (btn.equals("Xác nhận")) {
            handleChangePassword(account);
        } else if (btn.equals("Quên mật khẩu")) {
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
            AccountDTO accountDTO = accountService.findByUserNameAndPassword(username, password, 1);
            if (accountDTO != null) {
                if (accountDTO.getRoleId().equals("ADMIN")) {
                    loginUI.setVisible(false);
                    new AdminUI(accountDTO);
                } else if (accountDTO.getRoleId().equals("STAFF")) {
                    loginUI.setVisible(false);
                    new UserUI(accountDTO);
                }
            } else {
                JOptionPane.showMessageDialog(loginUI, "Thông tin đăng nhập không chính xác.");
            }
        }
    }

    public void checkAccount(String userName){
        AccountDTO accountDTO = accountService.findByUserName(userName, 1);
        if (accountDTO != null){
            this.account = accountDTO;
            JOptionPane.showMessageDialog(loginUI, "Tài khoản tồn tại.");
            loginUI.tFSignUp_username.setEditable(false);
            loginUI.tFSignUp_password.setEditable(true);
            loginUI.tFSignUp_repassword.setEditable(true);
            loginUI.btn_signup.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(loginUI, "Tài khoản không tồn tại.");
        }
    }

    public void handleChangePassword(AccountDTO accountDTO) {
        String username = loginUI.tFSignUp_username.getText().trim();
        String password = loginUI.tFSignUp_password.getText().trim();
        String rePassword = loginUI.tFSignUp_repassword.getText().trim();
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(loginUI, "Vui lòng điền đầy đủ thông tin!");
        } else if (rePassword.equals(password)) {
            accountDTO.setPassword(password);
            accountService.update(accountDTO);
            JOptionPane.showMessageDialog(loginUI, "Đổi mật khẩu thành công.");
            loginUI.tFSignUp_username.setEditable(true);
            loginUI.tFSignUp_password.setEditable(false);
            loginUI.tFSignUp_repassword.setEditable(false);
            loginUI.btn_signup.setEnabled(false);
            loginUI.showCard("panel_login");
        } else {
            JOptionPane.showMessageDialog(loginUI, "Mật khẩu không khớp.");
        }
    }
}

