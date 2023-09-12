package com.dainn.mapper;

import com.dainn.dto.AccountDTO;
import com.dainn.dto.ColorDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ColorMapper implements IRowMapper<ColorDTO>{

    @Override
    public ColorDTO mapRow(ResultSet rs) {
        try {
            ColorDTO colorDTO = new ColorDTO();
            colorDTO.setId(rs.getInt("id"));
            colorDTO.setName(rs.getString("name"));
            return colorDTO;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
