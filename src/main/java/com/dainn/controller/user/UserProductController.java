package com.dainn.controller.user;

import com.dainn.dto.ProductDTO;
import com.dainn.gui.ProductDetailUI;
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
                Integer minPrice = Integer.valueOf(userUI.tF_minPrice.getText());
                Integer maxPrice = Integer.valueOf(userUI.tF_maxPrice.getText());
                userUI.currentPanel.setVisible(false);
                List<ProductDTO> products;
                if (userUI.currentCategoryName.equals("all")){
                    products = productService.findByPriceInRanges(minPrice, maxPrice, 1, userUI.tF_find.getText().trim());
                } else {
                    products = productService.findByPriceInRanges(minPrice, maxPrice,
                            userUI.currentCategoryName, 1, userUI.tF_find.getText().trim());
                }
                userUI.currentPanel = userUI.addPanelProduct(userUI.panel_3, products, userUI.userProductController);
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(userUI, "Vui lòng nhập giá.");
            }
        } else if (btn.getName().equals("find")){
            List<ProductDTO> products;
            userUI.currentPanel.setVisible(false);
            String keyword = userUI.tF_find.getText().trim();
            if (userUI.currentCategoryName.equals("all")){
                products = productService.findByNameContaining(keyword, 1);
            } else {
                products = productService.findByNameContaining(keyword, userUI.currentCategoryName, 1);
            }
            userUI.currentPanel = userUI.addPanelProduct(userUI.panel_3, products, userUI.userProductController);
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
