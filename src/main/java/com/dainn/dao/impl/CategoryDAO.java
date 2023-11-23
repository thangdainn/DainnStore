package com.dainn.dao.impl;

import com.dainn.dao.ICategoryDAO;
import com.dainn.dto.CategoryDTO;
import com.dainn.mapper.CategoryMapper;
import com.dainn.mapper.ProductMapper;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryDTO> implements ICategoryDAO {
    @Override
    public CategoryDTO findByName(String name) {
        String sql = "SELECT * FROM category WHERE name = ?";
        List<CategoryDTO> categories = query(sql, new CategoryMapper(), name);
        return categories.isEmpty() ? null : categories.get(0);
    }

    @Override
    public CategoryDTO findById(Integer id) {
        String sql = "SELECT * FROM category WHERE id = ?";
        List<CategoryDTO> categories = query(sql, new CategoryMapper(), id);
        return categories.isEmpty() ? null : categories.get(0);
    }

    @Override
    public List<CategoryDTO> findALl(Integer status) {
        String sql = "SELECT * FROM category WHERE status = ?";
        return query(sql, new CategoryMapper(), status);
    }

    @Override
    public void update(CategoryDTO dto) {
        String sql = "UPDATE category SET name =?, description =? WHERE id =?";
        update(sql, dto.getName(), dto.getDescription(), dto.getId());
    }

    @Override
    public Integer save(CategoryDTO dto) {
        String sql = "INSERT INTO category(name, description) VALUES (?,?)";
        return insert(sql, dto.getName(), dto.getDescription());
    }

    @Override
    public void delete(Integer id) {
        String sql = "UPDATE category SET status = 0 WHERE id =?";
        update(sql, id);
    }

    @Override
    public List<CategoryDTO> findByIdOrNameContaining(String keyword, Integer status) {
        keyword = "%" + keyword + "%";
        String sql = "SELECT * FROM category WHERE status = ? AND (name LIKE ? OR id LIKE ?)";
        return query(sql, new CategoryMapper(), status, keyword, keyword);
    }
}
