package com.dainn.controller.user;

import com.dainn.dto.ProductDTO;
import com.dainn.dto.RomDTO;
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

public class UserProductDetailController implements ActionListener, MouseListener {

    private ProductDetailUI productDetailUI;
    private List<RomDTO> roms;
    private ProductDTO product;

    public UserProductDetailController(ProductDetailUI productDetailUI, List<RomDTO> roms, ProductDTO product) {
        this.productDetailUI = productDetailUI;
        this.roms = roms;
        this.product = product;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == productDetailUI.comboBox_rom) {
            setPrice(roms);
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

    public void setPrice(List<RomDTO> roms) {
        for (RomDTO rom : roms) {
            String romCapacity = (String) productDetailUI.comboBox_rom.getSelectedItem();
            if (rom.getCapacity().equals(romCapacity)) {
                productDetailUI.lbl_price.setText((product.getPrice() + product.getPrice() * rom.getPercent() / 100) + "");
            }
        }
    }
}
