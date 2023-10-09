package com.dainn.mapper;

import com.dainn.dto.OrderDetailDTO;
import com.dainn.dto.ReceiptDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptDetailMapper implements IRowMapper<ReceiptDetailDTO>{
    @Override
    public ReceiptDetailDTO mapRow(ResultSet rs) {
        try {
            ReceiptDetailDTO dto = new ReceiptDetailDTO();
            dto.setReceiptId(rs.getInt("receipt_id"));
            dto.setProductId(rs.getInt("product_id"));
            dto.setRomId(rs.getInt("rom_id"));
            dto.setQuantity(rs.getInt("quantity"));
            dto.setImportPrice(rs.getInt("importprice"));
            dto.setAmount(rs.getInt("amount"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
