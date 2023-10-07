package com.dainn.mapper;

import com.dainn.dto.CartDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartMapper implements IRowMapper<CartDTO>{
    @Override
    public CartDTO mapRow(ResultSet rs) {
        try {
            CartDTO dto = new CartDTO();
            dto.setId(rs.getInt("id"));
            dto.setAccountId(rs.getInt("account_id"));
            dto.setProductId(rs.getInt("product_id"));
            dto.setRomId(rs.getInt("rom_id"));
            dto.setPrice(rs.getInt("price"));
            dto.setQuantity(rs.getInt("quantity"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
