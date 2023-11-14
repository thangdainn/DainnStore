package com.dainn.service.impl;

import com.dainn.dao.ICategoryDAO;
import com.dainn.dao.impl.CategoryDAO;
import com.dainn.dto.CategoryDTO;
import com.dainn.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryDAO categoryDAO;

    public CategoryService() {
        this.categoryDAO = new CategoryDAO();
    }

    @Override
    public List<CategoryDTO> findAll() {
        return null;
    }
}
