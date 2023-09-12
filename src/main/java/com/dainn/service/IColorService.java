package com.dainn.service;

import com.dainn.dto.ColorDTO;

import java.util.List;

public interface IColorService {
    List<ColorDTO> findAll();
    List<ColorDTO> findByName(String name);
}
