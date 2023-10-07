package com.dainn.dao.impl;

import com.dainn.dao.IProductDAO;
import com.dainn.dto.ProductDTO;
import com.dainn.mapper.ProductMapper;

import java.util.List;

public class ProductDAO extends AbstractDAO<ProductDTO> implements IProductDAO {
    @Override
    public List<ProductDTO> findByCategoryId(Integer id, Integer status) {
        String sql = "SELECT * FROM product WHERE category_id = ? AND quantity > 0 AND status = ?";
        return query(sql, new ProductMapper(), id, status);
    }

    @Override
    public List<ProductDTO> findAll() {
        String sql = "SELECT * FROM product";
        return query(sql, new ProductMapper());
    }

    @Override
    public List<ProductDTO> findByQuantityGreaterZero(Integer status) {
        String sql = "SELECT * FROM product WHERE quantity > 0 AND status = ?";
        return query(sql, new ProductMapper(), status);
    }

    @Override
    public List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer categoryId, Integer status) {
        String sql = "SELECT * FROM product WHERE category_id = ? AND status = ? AND price BETWEEN ? AND ?";
        return query(sql, new ProductMapper(), categoryId, status, fromPrice, toPrice);
    }

    @Override
    public List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer status) {
        String sql = "SELECT * FROM product WHERE status = ? AND price BETWEEN ? AND ?";
        return query(sql, new ProductMapper(), status, fromPrice, toPrice);
    }

    @Override
    public List<ProductDTO> findByNameContaining(String keyword, Integer categoryId, Integer status) {
        keyword = "%" + keyword + "%";
        String sql = "SELECT * FROM product WHERE category_id = ? AND status = ? AND name LIKE ?";
        return query(sql, new ProductMapper(), categoryId, status, keyword);
    }

    @Override
    public List<ProductDTO> findByNameContaining(String keyword, Integer status) {
        keyword = "%" + keyword + "%";
        String sql = "SELECT * FROM product WHERE status = ? AND name LIKE ?";
        return query(sql, new ProductMapper(), status, keyword);
    }

    @Override
    public ProductDTO findById(Integer id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        List<ProductDTO> list = query(sql, new ProductMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void updateQuantityById(Integer id) {
        String sql = "UPDATE product p " +
                "JOIN (" +
                "SELECT product_id, SUM(quantity) AS total_quantity" +
                " FROM product_rom" +
                " GROUP BY product_id" +
                ") pr ON p.id = pr.product_id" +
                " SET p.quantity = pr.total_quantity" +
                "WHERE p.id = ?";
        update(sql, id);
    }
}
