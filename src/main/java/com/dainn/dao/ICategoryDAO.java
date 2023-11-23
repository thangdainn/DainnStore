package com.dainn.dao;

import com.dainn.dto.CategoryDTO;
import com.dainn.dto.ProductDTO;

import java.util.List;

public interface ICategoryDAO {
    CategoryDTO findByName(String name);
    CategoryDTO findById(Integer id);
    List<CategoryDTO> findALl(Integer status);
    void update(CategoryDTO dto);
    Integer save(CategoryDTO dto);
    void delete(Integer id);
    List<CategoryDTO> findByIdOrNameContaining(String keyword, Integer status);

}
