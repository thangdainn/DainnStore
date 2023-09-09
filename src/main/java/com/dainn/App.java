package com.dainn;

import com.dainn.gui.LoginUI;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new LoginUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
