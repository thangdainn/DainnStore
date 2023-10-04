package com.dainn.controller.user;

import com.dainn.dto.ProductDTO;
import com.dainn.gui.UserUI;
import com.dainn.service.IProductService;
import com.dainn.service.impl.ProductService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class UserProductController implements ActionListener, MouseListener {

    private UserUI userUI;
    private IProductService productService;

    public UserProductController(UserUI userUI) {
        this.userUI = userUI;
        this.productService = new ProductService();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if (btn.getName().equals("addCart")){
        } else if (btn.getName().equals("filterByPrice")){
            try {
                Integer minPrice = Integer.valueOf(this.userUI.tF_minPrice.getText());
                Integer maxPrice = Integer.valueOf(this.userUI.tF_maxPrice.getText());
                this.userUI.currentPanel.setVisible(false);
                List<ProductDTO> products;
                if (this.userUI.currentCategoryName.equals("all")){
                    products = this.productService.findByPriceInRanges(minPrice, maxPrice, 1);
                } else {
                    products = this.productService.findByPriceInRanges(minPrice, maxPrice,
                            this.userUI.currentCategoryName, 1);
                }
                this.userUI.currentPanel = this.userUI.addPanelProduct(this.userUI.panel_3, products, this.userUI.userProductController);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(this.userUI, "Vui lòng nhập giá.");
            }
        } else if (btn.getName().equals("find")){
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
        JPanel panel = (JPanel) e.getSource();
        panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
