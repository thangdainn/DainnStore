package com.dainn.service.impl;

import com.dainn.dao.IReceiptDetailDAO;
import com.dainn.dao.impl.ReceiptDetailDAO;
import com.dainn.dto.ReceiptDetailDTO;
import com.dainn.service.IReceiptDetailService;

public class ReceiptDetailService implements IReceiptDetailService {
    private IReceiptDetailDAO receiptDetailDAO;

    public ReceiptDetailService() {
        this.receiptDetailDAO = new ReceiptDetailDAO();
    }


    @Override
    public void save(ReceiptDetailDTO dto) {
        receiptDetailDAO.save(dto);
    }
}
