package com.dainn.controller.user;

import com.dainn.dto.AccountDTO;
import com.dainn.dto.CartDTO;
import com.dainn.dto.ProductDTO;
import com.dainn.dto.RomDTO;
import com.dainn.gui.ProductDetailUI;
import com.dainn.gui.UserUI;
import com.dainn.service.ICartService;
import com.dainn.service.IRomService;
import com.dainn.service.impl.CartService;
import com.dainn.service.impl.RomService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserProductDetailController implements ActionListener {

    private ICartService cartService = new CartService();
    private IRomService romService = new RomService();
    private ProductDetailUI productDetailUI;
    private List<RomDTO> roms;
    private ProductDTO product;
    private AccountDTO account;

    public UserProductDetailController(ProductDetailUI productDetailUI, List<RomDTO> roms, ProductDTO product, AccountDTO account) {
        this.productDetailUI = productDetailUI;
        this.roms = roms;
        this.product = product;
        this.account = account;
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
                if (roms.get(0).getCapacity().equals("")){
                    dto.setRomId(6);
                } else {
                    for (RomDTO rom : roms) {
                        String romCapacity = (String) productDetailUI.comboBox_rom.getSelectedItem();
                        if (rom.getCapacity().equals(romCapacity)) {
                            dto.setRomId(rom.getId());
                            break;
                        }
                    }
                }
                dto.setPrice(productDetailUI.price);
                CartDTO cartDTO = cartService.findByAccount_IdAndProduct_IdAndRom_Id(dto);
                if (cartDTO == null){
                    dto.setQuantity(1);
                    dto = cartService.save(dto);
                    UserUI.lblQtyInCart.setText(Integer.parseInt(UserUI.lblQtyInCart.getText()) + 1 + "");

                } else if (cartDTO.getQuantity() == romService.getQuantityOfPR(product.getId(), dto.getRomId())){
                    JOptionPane.showMessageDialog(productDetailUI, "Sản phẩm đã hết hàng!!!");
                } else {
                    dto.setId(cartDTO.getId());
                    dto.setQuantity(cartDTO.getQuantity() + 1);
                    dto = cartService.update(dto);
                }
                if (dto.getId() != null){
                    JOptionPane.showMessageDialog(productDetailUI, "Đã thêm vào giỏ hàng!!!");
                    productDetailUI.dispose();
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
