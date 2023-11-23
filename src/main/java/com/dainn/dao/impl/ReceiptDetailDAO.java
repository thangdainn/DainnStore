package com.dainn.dao.impl;

import com.dainn.dao.IReceiptDetailDAO;
import com.dainn.dto.ReceiptDetailDTO;
import com.dainn.mapper.ReceiptDetailMapper;

import java.util.List;


public class ReceiptDetailDAO extends AbstractDAO<ReceiptDetailDTO> implements IReceiptDetailDAO {

    @Override
    public void save(ReceiptDetailDTO dto) {
        String sql = "INSERT INTO receiptdetail(receipt_id, product_id, rom_id, quantity, importprice, amount) VALUES(?,?,?,?,?,?)";
        update(sql, dto.getReceiptId(), dto.getProductId(), dto.getRomId(), dto.getQuantity(), dto.getImportPrice(), dto.getAmount());
    }

    @Override
    public List<ReceiptDetailDTO> findByReceipt_Id(Integer id) {
        String sql = "SELECT * FROM receiptdetail WHERE receipt_id = ?";
        return query(sql, new ReceiptDetailMapper(), id);
    }

}
