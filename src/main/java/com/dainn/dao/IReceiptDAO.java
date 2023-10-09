package com.dainn.dao;

import com.dainn.dto.ReceiptDTO;

public interface IReceiptDAO {
    Integer save(ReceiptDTO dto);
    ReceiptDTO findById(Integer id);
}
