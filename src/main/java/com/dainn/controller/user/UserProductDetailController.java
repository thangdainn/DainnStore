package com.dainn.controller.user;

import com.dainn.dto.CartDTO;
import com.dainn.dto.ProductDTO;
import com.dainn.dto.RomDTO;
import com.dainn.gui.ProductDetailUI;
import com.dainn.service.ICartService;
import com.dainn.service.impl.CartService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserProductDetailController implements ActionListener {

    private ICartService cartService = new CartService();
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
        } else {
            String action = e.getActionCommand();
            if (action.equals("Thêm vào giỏ hàng")){
                CartDTO dto = new CartDTO();
                dto.setAccountId(productDetailUI.accountDTO.getId());
                dto.setProductId(productDetailUI.productDTO.getId());
                if (roms != null){
                    for (RomDTO rom : roms) {
                        String romCapacity = (String) productDetailUI.comboBox_rom.getSelectedItem();
                        if (rom.getCapacity().equals(romCapacity)) {
                            dto.setRomId(rom.getId());
                            break;
                        }
                    }
                } else {
                    dto.setRomId(6);
                }
                dto.setPrice(productDetailUI.price);
                CartDTO cartDTO = cartService.findByAccount_IdAndProduct_IdAndRom_Id(dto);
                if (cartDTO == null){
                    dto.setQuantity(1);
                    dto = cartService.save(dto);

                } else {
                    dto.setId(cartDTO.getId());
                    dto.setQuantity(cartDTO.getQuantity() + 1);
                    dto = cartService.update(dto);
                }
                if (dto.getId() != null){
                    JOptionPane.showMessageDialog(productDetailUI, "Đã thêm vào giỏ hàng!!!");
                }
            }
        }
    }


    public void setPrice(List<RomDTO> roms) {
        for (RomDTO rom : roms) {
            String romCapacity = (String) productDetailUI.comboBox_rom.getSelectedItem();
            if (rom.getCapacity().equals(romCapacity)) {
                productDetailUI.price = (product.getPrice() + product.getPrice() * rom.getPercent() / 100);
                productDetailUI.lbl_price.setText(productDetailUI.price.toString());
            }
        }
    }
}
