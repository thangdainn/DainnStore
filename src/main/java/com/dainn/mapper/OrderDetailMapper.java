package com.dainn.mapper;

import com.dainn.dto.OrderDetailDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailMapper implements IRowMapper<OrderDetailDTO>{
    @Override
    public OrderDetailDTO mapRow(ResultSet rs) {
        try {
            OrderDetailDTO dto = new OrderDetailDTO();
            dto.setOrderId(rs.getInt("order_id"));
            dto.setProductId(rs.getInt("product_id"));
            dto.setRomId(rs.getInt("rom_id"));
            dto.setQuantity(rs.getInt("quantity"));
            dto.setPrice(rs.getInt("price"));
            dto.setAmount(rs.getInt("amount"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
