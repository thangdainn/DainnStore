package com.dainn.dao.impl;

import com.dainn.dao.IColorDAO;
import com.dainn.dto.ColorDTO;
import com.dainn.mapper.ColorMapper;

import java.util.List;

public class ColorDAO extends AbstractDAO<ColorDTO> implements IColorDAO {
    @Override
    public List<ColorDTO> findAll() {
        String sql = "SELECT * FROM color";
        return query(sql, new ColorMapper());
    }

    @Override
    public List<ColorDTO> findByName(String name) {
        String sql = "SELECT * FROM color WHERE name = ?";
        return query(sql, new ColorMapper(), name);
    }
}
