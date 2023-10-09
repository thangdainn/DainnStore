package com.dainn.dao.impl;

import com.dainn.dao.IReceiptDetailDAO;
import com.dainn.dto.ReceiptDetailDTO;


public class ReceiptDetailDAO extends AbstractDAO<ReceiptDetailDTO> implements IReceiptDetailDAO {

    @Override
    public void save(ReceiptDetailDTO dto) {
        String sql = "INSERT INTO receiptdetail(receipt_id, product_id, rom_id, quantity, importprice, amount) VALUES(?,?,?,?,?,?)";
        update(sql, dto.getReceiptId(), dto.getProductId(), dto.getRomId(), dto.getQuantity(), dto.getImportPrice(), dto.getAmount());
    }

}
