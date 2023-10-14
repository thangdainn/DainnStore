package com.dainn.service;

import com.dainn.dto.CartDTO;

import java.sql.Connection;
import java.util.List;

public interface ICartService {
    List<CartDTO> findByAccount_Id(Integer id);
    CartDTO save(CartDTO dto);
    CartDTO update(CartDTO dto);
    void delete(Integer id);
    CartDTO findByAccount_IdAndProduct_IdAndRom_Id(CartDTO dto);
    void dropTable();
    Connection getConnection();
}
