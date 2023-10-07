package com.dainn.controller.user;

import javax.swing.*;

import com.dainn.dto.ProductDTO;
import com.dainn.gui.UserUI;
import com.dainn.service.IProductService;
import com.dainn.service.impl.ProductService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class UserHomeController implements ActionListener, MouseListener {
	
	private UserUI userUI;
	private IProductService productService;
	
    public UserHomeController(UserUI userUI) {
		this.userUI = userUI;
		this.productService = new ProductService();
	}

	@Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.userUI.currentPanel.setVisible(false);
    	JPanel panel = (JPanel) e.getSource();
    	String result = this.userUI.handleShowCard(panel);
    	if (result.equals("all")) {
    		List<ProductDTO> products = this.productService.findByQuantityGreaterZero(1);
    		this.userUI.currentPanel = this.userUI.addPanelProduct(this.userUI.panel_3, products, this.userUI.userProductController);
    	} else if (result.equals("receipt")) {
    		
    	} else {
    		List<ProductDTO> products = this.productService.findByCategoryName(result, 1);
            this.userUI.currentPanel = this.userUI.addPanelProduct(this.userUI.panel_3, products, this.userUI.userProductController);
    	}
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
    
    
}
