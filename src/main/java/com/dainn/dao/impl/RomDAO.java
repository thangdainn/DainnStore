package com.dainn.dao.impl;

import com.dainn.dao.IRomDAO;
import com.dainn.dto.RomDTO;
import com.dainn.mapper.RomMapper;

import java.util.List;

public class RomDAO extends AbstractDAO<RomDTO> implements IRomDAO {
    @Override
    public List<RomDTO> findAll() {
        String sql = "SELECT * FROM rom";
        return query(sql, new RomMapper());
    }

    @Override
    public List<RomDTO> findByProduct_Id(Integer id) {
        String sql = "SELECT * FROM rom r JOIN product_rom pr ON r.id = pr.rom_id WHERE pr.product_id = ?";
        return query(sql, new RomMapper(), id);
    }
}
