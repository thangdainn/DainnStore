package com.dainn.dao;

import com.dainn.dto.ColorDTO;

import java.util.List;

public interface IColorDAO {
    List<ColorDTO> findAll();
    List<ColorDTO> findByName(String name);
}
