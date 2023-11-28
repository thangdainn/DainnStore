package com.dainn.controller.admin;

import com.dainn.dto.CustomerDTO;
import com.dainn.dto.ReceiptDTO;
import com.dainn.gui.AdminUI;
import com.dainn.gui.ReceiptDetailUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdminReceiptController implements ActionListener, MouseListener {

    private AdminUI adminUI;

    public AdminReceiptController(AdminUI adminUI) {
        this.adminUI = adminUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        Object source = e.getSource();
        if (action.equals("Lưu phiếu")) {
            handleUpdate();
        } else if (action.equals("Xóa phiếu")) {
            handleDelete();
        } else if (action.equals("Xóa tất cả")) {
            handleDeleteAll();
        } else if (action.equals("Làm mới")) {
            adminUI.handleFormCleanReceipt();
        } else if (action.equals("Tìm")) {
            handleFindByKeyword();
        } else if (source == adminUI.comboBox_receiptMonth) {
            handleFindByMonth();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int row = adminUI.table_receipt.getSelectedRow();
            handleShowReceiptDetail(row);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int row = adminUI.table_receipt.getSelectedRow();
        adminUI.showReceiptToCpn(row);

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void handleShowReceiptDetail(int row) {
        DefaultTableModel tableOrderModel = (DefaultTableModel) this.adminUI.table_receipt.getModel();
        Integer id = Integer.valueOf(tableOrderModel.getValueAt(row, 0) + "");
        new ReceiptDetailUI(id);
    }

    private void handleUpdate() {
        if (!adminUI.textField_receiptId.getText().isEmpty()) {
            ReceiptDTO receipt = adminUI.receiptService.findById(Integer.valueOf(adminUI.textField_receiptId.getText()), 1);
            Integer supplId = (Integer) adminUI.comboBox_receiptSuppId.getSelectedItem();
            if (!supplId.equals(receipt.getSupplierId())) {
                receipt.setSupplierId(supplId);
                adminUI.receiptService.update(receipt);
                adminUI.handleShowReceiptToTable(adminUI.receiptService.findAll(1));
            }
            adminUI.formCleanReceipt();
            JOptionPane.showMessageDialog(adminUI, "Cập nhật phiếu nhập thành công.");
        } else {
            JOptionPane.showMessageDialog(adminUI, "Vui lòng chọn phiếu nhập");
        }
    }

    private void handleDelete() {
        if (!adminUI.textField_receiptId.getText().isEmpty()) {
            int confirm = JOptionPane.showConfirmDialog(adminUI, "Bạn có chắc chắn xóa?", "Conform", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                adminUI.receiptService.delete(Integer.valueOf(adminUI.textField_receiptId.getText()));
                adminUI.formCleanReceipt();
                adminUI.handleShowReceiptToTable(adminUI.receiptService.findAll(1));
                JOptionPane.showMessageDialog(adminUI, "Xóa phiếu nhập thành công.");
            }
        } else {
            JOptionPane.showMessageDialog(adminUI, "Vui lòng chọn phiếu nhập");
        }
    }

    private void handleDeleteAll() {
        int confirm = JOptionPane.showConfirmDialog(adminUI, "Bạn có chắc chắn xóa tất cả?", "Conform", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            for (ReceiptDTO dto : adminUI.receiptService.findAll(1)) {
                adminUI.receiptService.delete(dto.getId());
            }
            adminUI.formCleanReceipt();
            adminUI.handleShowReceiptToTable(adminUI.receiptService.findAll(1));
            JOptionPane.showMessageDialog(adminUI, "Xóa tất cả phiếu nhập thành công.");
        }
    }

    private void handleFindByKeyword() {
        String keyword = adminUI.textField_receiptFind.getText();
        adminUI.handleShowReceiptToTable(adminUI.receiptService.findByKeyword(keyword, 1));
    }

    private void handleFindByMonth() {
        if (adminUI.comboBox_receiptMonth.getSelectedIndex() != 0) {
            Integer month = (Integer) adminUI.comboBox_receiptMonth.getSelectedItem();
            adminUI.handleShowReceiptToTable(adminUI.receiptService.findByMonth(month, 1));
        }
    }
}
