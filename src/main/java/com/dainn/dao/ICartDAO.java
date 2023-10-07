package com.dainn.dao;

import com.dainn.dto.CartDTO;

import java.util.List;

public interface ICartDAO {
    List<CartDTO> findByAccount_Id(Integer id);
    Integer save(CartDTO dto);
    void delete(Integer id);
    void update(CartDTO dto);
    CartDTO findById(Integer id);
    CartDTO findByAccount_IdAndProduct_IdAndRom_Id(Integer accountId, Integer productId, Integer romId);
}
