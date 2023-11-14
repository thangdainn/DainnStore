package com.dainn.mapper;

import com.dainn.dto.StatisticDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StatisticMapper implements IRowMapper<StatisticDTO>{
    @Override
    public StatisticDTO mapRow(ResultSet rs) {
        try {
            StatisticDTO dto = new StatisticDTO();
            dto.setName(rs.getString("name"));
            dto.setTotalQty(rs.getInt("totalQty"));
            dto.setTotalPrice(rs.getInt("totalPrice"));
            return dto;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
