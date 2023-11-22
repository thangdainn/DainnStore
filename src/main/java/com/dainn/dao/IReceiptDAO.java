package com.dainn.dao;

import com.dainn.dto.ReceiptDTO;

import java.util.List;

public interface IReceiptDAO {
    Integer save(ReceiptDTO dto);
    void update(ReceiptDTO dto);
    void delete(Integer id);
    ReceiptDTO findById(Integer id, Integer status);
    List<ReceiptDTO> findByStatus(Integer status);
    List<ReceiptDTO> findByKeyword(String keyword, Integer status);
    List<ReceiptDTO> findByMonth(Integer month, Integer status);
}
