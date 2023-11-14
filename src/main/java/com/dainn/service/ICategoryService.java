package com.dainn.service;

import com.dainn.dto.CategoryDTO;
import com.dainn.dto.RomDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> findAll();
}
