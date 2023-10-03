package com.dainn.mapper;

import com.dainn.dto.RomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RomMapper implements IRowMapper<RomDTO>{

    @Override
    public RomDTO mapRow(ResultSet rs) {
        try {
            RomDTO romDTO = new RomDTO();
            romDTO.setId(rs.getInt("id"));
            romDTO.setCapacity(rs.getString("capacity"));
            romDTO.setPercent(rs.getInt("percent"));
            return romDTO;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
