package com.dainn.mapper;

import com.dainn.dto.ReceiptDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements IRowMapper<ReceiptDTO>{
    @Override
    public ReceiptDTO mapRow(ResultSet rs) {
        try {
            ReceiptDTO dto = new ReceiptDTO();
            dto.setId(rs.getInt("id"));
            dto.setSupplierId(rs.getInt("supplier_id"));
            dto.setAccountId(rs.getInt("account_id"));
            dto.setCreatedDate(rs.getTimestamp("createddate"));
            dto.setTotalPrice(rs.getInt("totalprice"));
            dto.setStatus(rs.getInt("status"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
