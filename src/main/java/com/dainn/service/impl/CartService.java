package com.dainn.service.impl;

import com.dainn.dao.ICartDAO;
import com.dainn.dao.impl.CartDAO;
import com.dainn.dto.CartDTO;
import com.dainn.service.ICartService;

import java.sql.Connection;
import java.util.List;

public class CartService implements ICartService {
    private ICartDAO cartDAO;

    public CartService() {
        this.cartDAO = new CartDAO();
    }

    @Override
    public List<CartDTO> findByAccount_Id(Integer id) {
        List<CartDTO> list = cartDAO.findByAccount_Id(id);
        return list.isEmpty() ? null : list;
    }

    @Override
    public CartDTO save(CartDTO dto) {
        Integer id = cartDAO.save(dto);
        dto = cartDAO.findById(id);
        return dto;
    }

    @Override
    public CartDTO update(CartDTO dto) {
        CartDTO old = cartDAO.findById(dto.getId());
        dto.setAccountId(old.getAccountId());
        dto.setProductId(old.getProductId());
        dto.setRomId(old.getRomId());
        dto.setPrice(old.getPrice());
        cartDAO.update(dto);
        return cartDAO.findById(dto.getId());
    }

    @Override
    public void delete(Integer id) {
        cartDAO.delete(id);
    }

    @Override
    public CartDTO findByAccount_IdAndProduct_IdAndRom_Id(CartDTO dto) {
        return cartDAO.findByAccount_IdAndProduct_IdAndRom_Id(dto.getAccountId(), dto.getProductId(), dto.getRomId());
    }

    @Override
    public void dropTable() {
        cartDAO.dropTable();
    }

    @Override
    public Connection getConnection() {
        return cartDAO.getConnection();
    }
}
