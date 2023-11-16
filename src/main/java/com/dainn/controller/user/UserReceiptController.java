package com.dainn.controller.user;

import com.dainn.dto.ProductDTO;
import com.dainn.dto.ReceiptDTO;
import com.dainn.dto.ReceiptDetailDTO;
import com.dainn.gui.UserUI;
import com.dainn.service.*;
import com.dainn.service.impl.*;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UserReceiptController implements ActionListener {

    private UserUI userUI;
    private IRomService romService = new RomService();
    private IProductService productService = new ProductService();
    private ISupplierService supplierService = new SupplierService();
    private IReceiptService receiptService = new ReceiptService();
    private IReceiptDetailService receiptDetailService = new ReceiptDetailService();
    private List<ReceiptDetailDTO> receiptDetails = new ArrayList<>();
    private Integer totalPrice = 0;


    public UserReceiptController(UserUI userUI) {
        this.userUI = userUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Thêm vào phiếu")) {
            addDataToTable(receiptDetails);
            handleTotalPrice();
        } else if (action.equals("Xóa sản phẩm")) {
            DefaultTableModel tableModel = (DefaultTableModel) userUI.table_receiptProd.getModel();
            int row = userUI.table_receiptProd.getSelectedRow();
            if (row == -1){
                JOptionPane.showMessageDialog(userUI, "Chọn sản phẩm để xóa.");
            } else {
                Integer prodId = (Integer) tableModel.getValueAt(row, 0);
                String romCapacity = (String) tableModel.getValueAt(row, 2);
                Integer romId = romService.findByCapacity(romCapacity).getId();
                for (ReceiptDetailDTO dto : receiptDetails){
                    if (prodId.equals(dto.getProductId()) && romId.equals(dto.getRomId())){
                        receiptDetails.remove(dto);
                        break;
                    }
                }
                tableModel.removeRow(row);
                handleTotalPrice();
            }
        } else if (action.equals("Xóa tất cả")) {
            DefaultTableModel tableModel = (DefaultTableModel) userUI.table_receiptProd.getModel();
            tableModel.setRowCount(0);
            receiptDetails.clear();
            userUI.tF_receiptTotalPrice.setText("0");
        } else if (action.equals("Tạo phiếu")) {
            if (!receiptDetails.isEmpty()){
                ReceiptDTO receipt = save();
                if (receipt != null){
                    handleSaveReceiptDetail(receipt, receiptDetails);
                    JOptionPane.showMessageDialog(userUI, "Tạo phiếu thành công!!!");
                    formClean();
                }
            } else {
                JOptionPane.showMessageDialog(userUI, "Danh sách sản phẩm nhập hàng trống.");
            }
        } else if (action.equals("Nhập phiếu")){
            importExcelIntoTable();
        }
    }

    private void handleTotalPrice(){
        Integer sum = 0;
        for (ReceiptDetailDTO dto : receiptDetails){
            sum += dto.getAmount();
        }
        totalPrice = sum;
        userUI.tF_receiptTotalPrice.setText(totalPrice.toString());
    }

    private void formClean(){
        DefaultTableModel tableModel = (DefaultTableModel) userUI.table_receiptProd.getModel();
        tableModel.setRowCount(0);
        userUI.comboBox_receiptSuppName.setSelectedIndex(0);
        userUI.comboBox_receiptRom.setSelectedIndex(0);
        userUI.comboBox_receiptProdId.setSelectedIndex(0);
        userUI.tF_receiptQuantity.setText("");
        userUI.tF_receiptImportPrice.setText("");
        userUI.tF_receiptTotalPrice.setText("0");
    }

    private ReceiptDTO save(){
        if (userUI.comboBox_receiptSuppName.getSelectedIndex() != 0){
            Integer suppId = supplierService.findByName((String) userUI.comboBox_receiptSuppName.getSelectedItem()).getId();
            ReceiptDTO receipt = new ReceiptDTO();
            receipt.setSupplierId(suppId);
            receipt.setAccountId(userUI.account.getId());
            receipt.setTotalPrice(totalPrice);
            return receiptService.save(receipt);
        }
        JOptionPane.showMessageDialog(userUI, "Vui lòng chọn nhà cung cấp.");
        return null;
    }

    private void handleSaveReceiptDetail(ReceiptDTO receipt, List<ReceiptDetailDTO> list) {
        for (ReceiptDetailDTO dto : list){
            dto.setReceiptId(receipt.getId());
            receiptDetailService.save(dto);
            romService.updateQuantityOfPR(dto.getProductId(), dto.getRomId(), dto.getQuantity());
            ProductDTO product = productService.findById(dto.getProductId());
            product.setPrice(dto.getImportPrice());
            product.setQuantity(product.getQuantity() + dto.getQuantity());
            productService.update(product);
            productService.updateQuantityById(dto.getProductId());
        }
    }

    private void addDataToTable(List<ReceiptDetailDTO> receiptDetails) {
        String error = "";
        String qtyText = userUI.tF_receiptQuantity.getText();
        String importPriceText = userUI.tF_receiptImportPrice.getText();
        if (qtyText.equals("") || importPriceText.equals("") || userUI.comboBox_receiptRom.getSelectedIndex() == 0 ||
                userUI.comboBox_receiptProdId.getSelectedIndex() == 0) {
            error = "Vui lòng nhập đủ thông tin.";
        }
        if (!error.equals("")) {
            JOptionPane.showMessageDialog(userUI, error);
        } else {
            Integer prodId = (Integer) userUI.comboBox_receiptProdId.getSelectedItem();
            String romCapacity = (String) userUI.comboBox_receiptRom.getSelectedItem();
            ProductDTO product = productService.findById(prodId);
            Integer romId = romService.findByCapacity(romCapacity).getId();
            if (product.getCategoryId() == 4 || product.getCategoryId() == 5){
                romId = 6;
            }
            Integer quantity = Integer.valueOf(qtyText);
            Integer importPrice = Integer.valueOf(importPriceText);
            int amount = quantity * importPrice;
            DefaultTableModel tableModel = (DefaultTableModel) userUI.table_receiptProd.getModel();
            if (!receiptDetails.isEmpty()) {
                boolean frag = false;
                for (ReceiptDetailDTO receiptDetail : receiptDetails) {
                    if (prodId.equals(receiptDetail.getProductId()) && romId.equals(receiptDetail.getRomId())) {
                        quantity += receiptDetail.getQuantity();
                        receiptDetail.setQuantity(quantity);
                        amount = quantity * importPrice;
                        receiptDetail.setAmount(amount);
                        int countRow = tableModel.getRowCount();
                        for (int i = 0; i < countRow; i++) {
                            String prodIdTable = tableModel.getValueAt(i, 0).toString();
                            String romCapacityTable = tableModel.getValueAt(i, 2).toString();
                            if (prodIdTable.equals(prodId.toString()) &&
                                    (romCapacityTable.equals(romCapacity) || romCapacityTable.equals("Không có"))) {
                                tableModel.setValueAt(quantity, i, 3);
                                tableModel.setValueAt(importPrice, i, 4);
                                tableModel.setValueAt(amount, i, 5);
                                break;
                            }
                        }
                        frag = true;
                        break;
                    }
                }
                if (!frag) {
                    tableModel.addRow(new Object[]{
                            prodId,
                            product.getName(),
                            romId == 6 ? "Không có" : romCapacity,
                            quantity,
                            importPrice,
                            amount
                    });
                    ReceiptDetailDTO receiptDetailDTO = new ReceiptDetailDTO(null, prodId, romId, quantity, importPrice, amount);
                    receiptDetails.add(receiptDetailDTO);
                }
            } else {
                tableModel.addRow(new Object[]{
                        prodId,
                        product.getName(),
                        romId == 6 ? "Không có" : romCapacity,
                        quantity,
                        importPrice,
                        amount
                });
                ReceiptDetailDTO receiptDetailDTO = new ReceiptDetailDTO(null, prodId, romId, quantity, importPrice, amount);
                receiptDetails.add(receiptDetailDTO);
            }
        }
    }

    private void importExcelIntoTable() {
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImport = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(userUI);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("xls", "xlsx", "xlsm");
        fileChooser.setFileFilter(filter);
        if (returnVal == JFileChooser.APPROVE_OPTION){
            try{
                excelFile = fileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImport = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImport.getSheetAt(0);
                DefaultTableModel tableModel = (DefaultTableModel) userUI.table_receiptProd.getModel();
                tableModel.setRowCount(0);
                for (int i = 0; i < excelSheet.getLastRowNum(); i++) {
                    XSSFRow excelRow = excelSheet.getRow(i);

                    XSSFCell excelId = excelRow.getCell(0);
                    XSSFCell excelName = excelRow.getCell(1);
                    XSSFCell excelRom = excelRow.getCell(2);
                    XSSFCell excelQuantity = excelRow.getCell(3);
                    XSSFCell excelImportPrice = excelRow.getCell(4);
                    XSSFCell excelAmount = excelRow.getCell(5);

                    Object idValue = getCellValue(excelId);
                    Object nameValue = getCellValue(excelName);
                    Object romValue = getCellValue(excelRom);
                    Object quantityValue = getCellValue(excelQuantity);
                    Object importPriceValue = getCellValue(excelImportPrice);
                    Object amountValue = getCellValue(excelAmount);

                    tableModel.addRow(new Object[]{
                            idValue, nameValue, romValue, quantityValue, importPriceValue, amountValue
                    });
                }
                JOptionPane.showMessageDialog(userUI, "Thêm dữ liệu thành công!");
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImport != null) {
                        excelImport.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }

        }
    }
    private Object getCellValue(XSSFCell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case NUMERIC:
                double numericValue = cell.getNumericCellValue();
                // Định dạng lại giá trị số để hiển thị dưới dạng số nguyên
                return new DecimalFormat("0").format(numericValue);
            case STRING:
                return cell.getStringCellValue();
            case FORMULA:
                try {
                    // Kiểm tra xem công thức có phải là số không
                    if (cell.getCachedFormulaResultType() == CellType.NUMERIC) {
                        double numericValue1 = cell.getNumericCellValue();
                        // Định dạng lại giá trị số để hiển thị dưới dạng số nguyên
                        return new DecimalFormat("0").format(numericValue1);
                    } else {
                        return cell.getStringCellValue();
                    }
                } catch (IllegalStateException e) {
                    return cell.getStringCellValue(); // Nếu không thể đọc được giá trị số, thì đọc giá trị chuỗi
                }
            // Các trường hợp khác có thể được thêm tùy thuộc vào yêu cầu của bạn
            default:
                return cell.getStringCellValue();
        }
    }
}
