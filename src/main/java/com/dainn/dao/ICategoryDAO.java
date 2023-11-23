package com.dainn.dao;

import com.dainn.dto.CategoryDTO;

import java.util.List;

public interface ICategoryDAO {
    CategoryDTO findByName(String name);
    CategoryDTO findById(Integer id);
    List<CategoryDTO> findALl(Integer status);
}
