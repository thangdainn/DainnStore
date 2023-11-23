package com.dainn.service;

import com.dainn.dto.OrderDetailDTO;
import com.dainn.dto.ReceiptDetailDTO;

import java.util.List;

public interface IReceiptDetailService {
    void save(ReceiptDetailDTO dto);
    List<ReceiptDetailDTO> findByReceipt_Id(Integer id);
}
