package com.dainn.mapper;

import com.dainn.dto.OrderDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements IRowMapper<OrderDTO>{
    @Override
    public OrderDTO mapRow(ResultSet rs) {
        try {
            OrderDTO dto = new OrderDTO();
            dto.setId(rs.getInt("id"));
            dto.setTotalPrice(rs.getInt("totalprice"));
            dto.setAccountId(rs.getInt("account_id"));
            dto.setCustomerId(rs.getInt("customer_id"));
            dto.setCreatedDate(rs.getDate("createddate"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
