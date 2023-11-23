package com.dainn.dao;

import com.dainn.dto.ReceiptDetailDTO;

import java.util.List;

public interface IReceiptDetailDAO {
    void save(ReceiptDetailDTO dto);
    List<ReceiptDetailDTO> findByReceipt_Id(Integer id);
}
