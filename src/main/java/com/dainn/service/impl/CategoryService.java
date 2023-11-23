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
    public List<CategoryDTO> findAll(Integer status) {
        List<CategoryDTO> list = categoryDAO.findALl(1);
        return list.isEmpty() ? null : list;
    }

    @Override
    public CategoryDTO findByName(String name) {
        return categoryDAO.findByName(name);
    }

    @Override
    public CategoryDTO finById(Integer id) {
        return categoryDAO.findById(id);
    }

    @Override
    public CategoryDTO update(CategoryDTO dto) {
        categoryDAO.update(dto);
        return categoryDAO.findById(dto.getId());
    }

    @Override
    public CategoryDTO save(CategoryDTO dto) {
        Integer id = categoryDAO.save(dto);
        return categoryDAO.findById(id);
    }

    @Override
    public void delete(Integer id) {
        categoryDAO.delete(id);
    }

    @Override
    public List<CategoryDTO> findByIdOrNameContaining(String keyword, Integer status) {
        return categoryDAO.findByIdOrNameContaining(keyword, status);
    }
}
