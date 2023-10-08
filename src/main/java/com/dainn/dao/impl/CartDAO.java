package com.dainn.dao.impl;

import com.dainn.dao.ICartDAO;
import com.dainn.dto.CartDTO;
import com.dainn.mapper.CartMapper;

import java.util.List;

public class CartDAO extends AbstractDAO<CartDTO> implements ICartDAO {

    @Override
    public List<CartDTO> findByAccount_Id(Integer id) {
        String sql = "SELECT * FROM cart WHERE account_id = ?";
        return query(sql, new CartMapper(), id);
    }

    @Override
    public Integer save(CartDTO dto) {
        String sql = "INSERT INTO cart(account_id, product_id, rom_id, price, quantity) VALUES(?,?,?,?,?)";
        return insert(sql, dto.getAccountId(), dto.getProductId(), dto.getRomId(), dto.getPrice(), dto.getQuantity());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM cart WHERE id = ?";
        update(sql, id);
    }

    @Override
    public void update(CartDTO dto) {
        String sql = "UPDATE cart SET quantity = ? WHERE id = ?";
        update(sql, dto.getQuantity(), dto.getId());
    }

    @Override
    public CartDTO findById(Integer id) {
        String sql = "SELECT * FROM cart WHERE id = ?";
        List<CartDTO> list = query(sql, new CartMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public CartDTO findByAccount_IdAndProduct_IdAndRom_Id(Integer accountId, Integer productId, Integer romId) {
        String sql = "SELECT * FROM cart WHERE account_id = ? AND product_id = ? AND rom_id = ?";
        List<CartDTO> list = query(sql, new CartMapper(), accountId, productId, romId);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void dropTable() {
        String sql = "DELETE FROM cart";
        update(sql);
    }
}
