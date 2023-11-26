package com.dainn.controller.admin;

import com.dainn.dto.ProductDTO;
import com.dainn.gui.AdminUI;
import com.dainn.utils.ImageUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class AdminProductController implements MouseListener, ActionListener {
    private AdminUI adminUI;

    public AdminProductController(AdminUI adminUI) {
        this.adminUI = adminUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Thêm")) {
            handleAdd();
        } else if (btn.equals("Lưu")) {
            this.handleUpdate();
        } else if (btn.equals("Xóa")) {
            this.handleDelete();
        } else if (btn.equals("Xóa tất cả")) {
            this.handleDeleteAll();
        } else if (btn.equals("Làm mới")) {
            this.adminUI.handleFormCleanProd();
        } else if (btn.equals("Tìm")) {
            this.findByIdOrName();
        } else if (btn.equals("Chọn ảnh")) {
            adminUI.imgPath = ImageUtil.selectImg(adminUI, adminUI.lbl_image);
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        int row = adminUI.table_product.getSelectedRow();
        adminUI.showProdDataToComponents(row);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    private ProductDTO getProdDataFromComponents() {
        String name = this.adminUI.textField_proName.getText().trim();
        String price = this.adminUI.textField_proPrice.getText().trim();
        String quantity = this.adminUI.textField_proQuantity.getText().trim();

        String error = "";
        if (name.isEmpty()) {
            error = "Nhập tên sản phẩm.";
        } else if (price.isEmpty()) {
            error = "Nhập giá sản phẩm.";
        } else if (quantity.isEmpty()) {
            error = "Nhập số lượng sản phẩm.";
        } else if (this.adminUI.comboBox_prodCateId.getSelectedIndex() < 1) {
            error = "Chọn loại sản phẩm.";
        } else if (this.adminUI.lbl_image.getIcon() == null) {
            error = "Chọn ảnh sản phẩm.";
        }

        if (!error.equals("")) {
            JOptionPane.showMessageDialog(this.adminUI, error);
            return null;
        } else {
            try {
                Integer priceInt = Integer.valueOf(price);
                Integer quantityInt = Integer.valueOf(quantity);
                String cateName = (String) this.adminUI.comboBox_prodCateId.getSelectedItem();
                String imgPath = this.adminUI.imgPath;
                ProductDTO product = new ProductDTO();
                product.setName(name);
                product.setQuantity(quantityInt);
                product.setPrice(priceInt);
                product.setImage(imgPath);
                product.setCategoryId(adminUI.categoryService.findByName(cateName).getId());
                return product;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private void handleAdd() {
        ProductDTO product = this.getProdDataFromComponents();
        if (product != null) {
            if (this.adminUI.textField_proId.getText().isEmpty()) {
                product = adminUI.productService.save(product);
                this.adminUI.addRowProduct(product);
                this.adminUI.formClearProd();
                JOptionPane.showMessageDialog(this.adminUI, "Thêm sản phẩm thành công.");
            } else {
                JOptionPane.showMessageDialog(this.adminUI, "Chọn làm mới trước khi thêm.");
            }
        }
    }

    private void handleUpdate() {
        if (!this.adminUI.textField_proId.getText().isEmpty()) {
            ProductDTO product = this.getProdDataFromComponents();
            if (product != null) {
                Integer prodId = Integer.valueOf(this.adminUI.textField_proId.getText());
                product.setId(prodId);
                adminUI.productService.update(product);
                adminUI.handleFormCleanProd();
                JOptionPane.showMessageDialog(this.adminUI, "Cập nhật sản phẩm thành công.");
            }
        } else {
            JOptionPane.showMessageDialog(this.adminUI, "Vui lòng chọn sản phẩm.");
        }
    }

    private void handleDelete() {
        if (this.adminUI.textField_proId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this.adminUI, "Chọn sản phẩm để xóa.");
        } else {
            Integer id = Integer.valueOf(this.adminUI.textField_proId.getText());
            int confirm = JOptionPane.showConfirmDialog(this.adminUI, "Bạn có chắc chắn xóa?", "Conform", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                adminUI.productService.delete(id);
                adminUI.handleFormCleanProd();
                JOptionPane.showMessageDialog(this.adminUI, "Xóa sản phẩm thành công.");
            }
        }
    }

    private void handleDeleteAll() {
        int confirm = JOptionPane.showConfirmDialog(this.adminUI, "Bạn có chắc chắn xóa?", "Conform", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            for (ProductDTO product : adminUI.productService.findAll(1)){
                adminUI.productService.delete(product.getId());
            }
            adminUI.handleFormCleanProd();
            JOptionPane.showMessageDialog(this.adminUI, "Xóa tất cả sản phẩm thành công.");
        }
    }

    private void findByIdOrName(){
        String keyword = adminUI.textfiel_proFind.getText();
        adminUI.showListProductToTable(adminUI.productService.findByIdOrNameContaining(keyword, 1));
    }
}
