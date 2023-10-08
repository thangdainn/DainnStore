package com.dainn.mapper;

import com.dainn.dto.AccountDTO;
import com.dainn.dto.CustomerDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements IRowMapper<CustomerDTO>{

    @Override
    public CustomerDTO mapRow(ResultSet rs) {
        try {
            CustomerDTO dto = new CustomerDTO();
            dto.setId(rs.getInt("id"));
            dto.setName(rs.getString("fullname"));
            dto.setAddress(rs.getString("address"));
            dto.setPhone(rs.getString("phone"));
            dto.setPoints(rs.getInt("points"));
            dto.setStatus(rs.getInt("status"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
