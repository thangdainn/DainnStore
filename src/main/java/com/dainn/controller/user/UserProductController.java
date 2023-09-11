package com.dainn.controller.user;

import com.dainn.gui.UserUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UserProductController implements ActionListener, MouseListener {

    private UserUI userUI;

    public UserProductController(UserUI userUI) {
        this.userUI = userUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.getName().equals("addCart")){
            System.out.printf("addCart");
        } else if (btn.getName().equals("filterByPrice")){
            if (this.userUI.currentCategoryName.equals("all")){

            } else {

            }
            System.out.printf("filterByPrice");
        } else if (btn.getName().equals("find")){
            System.out.printf("find");
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
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton btn = (JButton) e.getSource();
        btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
