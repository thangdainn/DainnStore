package com.dainn.mapper;

import com.dainn.dto.SupplierDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierMapper implements IRowMapper<SupplierDTO>{
    @Override
    public SupplierDTO mapRow(ResultSet rs) {
        try {
            SupplierDTO dto = new SupplierDTO();
            dto.setId(rs.getInt("id"));
            dto.setName(rs.getString("name"));
            dto.setAddress(rs.getString("address"));
            dto.setPhone(rs.getString("phone"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
