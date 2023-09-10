package com.dainn.dao.impl;

import com.dainn.dao.IProductDAO;
import com.dainn.dto.ProductDTO;
import com.dainn.mapper.ProductMapper;

import java.util.List;

public class ProductDAO extends AbstractDAO<ProductDTO> implements IProductDAO {
    @Override
    public List<ProductDTO> findByCategoryId(Integer id) {
        String sql = "SELECT * FROM product WHERE category_id = ?";
        return query(sql, new ProductMapper(), id);
    }

    @Override
    public List<ProductDTO> findAll() {
        String sql = "SELECT * FROM product";
        return query(sql, new ProductMapper());
    }
}
