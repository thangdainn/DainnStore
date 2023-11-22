package com.dainn.service;

import com.dainn.dto.ReceiptDTO;

import java.util.List;

public interface IReceiptService {
    ReceiptDTO save(ReceiptDTO dto);
    ReceiptDTO update(ReceiptDTO dto);
    void delete(Integer id);
    List<ReceiptDTO> findAll(Integer status);
    ReceiptDTO findById(Integer id, Integer status);
    List<ReceiptDTO> findByKeyword(String keyword, Integer status);
    List<ReceiptDTO> findByMonth(Integer month, Integer status);

}
