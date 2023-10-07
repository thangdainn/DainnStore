package com.dainn.controller.user;

import com.dainn.gui.CartUI;
import com.dainn.gui.UserUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class UserCartController implements ActionListener, FocusListener {

    private CartUI cartUI;

    public UserCartController(CartUI cartUI) {
        this.cartUI = cartUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }


}
