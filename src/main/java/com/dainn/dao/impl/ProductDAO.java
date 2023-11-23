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
    public List<ProductDTO> findAll(Integer status) {
        String sql = "SELECT * FROM product WHERE status = ?";
        return query(sql, new ProductMapper(), status);
    }

    @Override
    public List<ProductDTO> findByQuantityGreaterZero(Integer status) {
        String sql = "SELECT * FROM product WHERE quantity > 0 AND status = ?";
        return query(sql, new ProductMapper(), status);
    }

    @Override
    public List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer categoryId, Integer status, String keyword) {
        keyword = "%" + keyword + "%";
        String sql = "SELECT * FROM product WHERE category_id = ? AND name LIKE ? AND status = ? AND price BETWEEN ? AND ?";
        return query(sql, new ProductMapper(), categoryId, keyword, status, fromPrice, toPrice);
    }

    @Override
    public List<ProductDTO> findByInRanges(Integer fromPrice, Integer toPrice, Integer status, String keyword) {
        keyword = "%" + keyword + "%";
        String sql = "SELECT * FROM product WHERE name LIKE ? AND status = ? AND price BETWEEN ? AND ?";
        return query(sql, new ProductMapper(), keyword, status, fromPrice, toPrice);
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
    public List<ProductDTO> findByIdOrNameContaining(String keyword, Integer status) {
        keyword = "%" + keyword + "%";
        String sql = "SELECT * FROM product WHERE status = ? AND name LIKE ? OR id LIKE ?";
        return query(sql, new ProductMapper(), status, keyword, keyword);
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
                " WHERE p.id = ?";
        update(sql, id);
    }

    @Override
    public void update(ProductDTO dto) {
        String sql = "UPDATE product SET category_id =?, name=?, price=?, quantity=?, image=? WHERE id =?";
        update(sql, dto.getCategoryId(), dto.getName(), dto.getPrice(), dto.getQuantity(), dto.getImage(), dto.getId());
    }

    @Override
    public Integer save(ProductDTO dto) {
        String sql = "INSERT INTO product(category_id, name, price, quantity, image) VALUES (?,?,?,?,?)";
        return insert(sql, dto.getCategoryId(), dto.getName(), dto.getPrice(), dto.getQuantity(), dto.getImage());
    }

    @Override
    public void delete(Integer id) {
        String sql = "UPDATE product SET status=0 WHERE id =?";
        update(sql, id);
    }
}
