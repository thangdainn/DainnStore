package com.dainn.dao.impl;

import com.dainn.dao.ICategoryDAO;
import com.dainn.dto.CategoryDTO;
import com.dainn.mapper.CategoryMapper;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryDTO> implements ICategoryDAO {
    @Override
    public CategoryDTO findByName(String name) {
        String sql = "SELECT * FROM category WHERE name = ?";
        List<CategoryDTO> categories = query(sql, new CategoryMapper(), name);
        return categories.isEmpty() ? null : categories.get(0);
    }
}
