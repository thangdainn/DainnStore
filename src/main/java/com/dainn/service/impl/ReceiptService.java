package com.dainn.service.impl;

import com.dainn.dao.IReceiptDAO;
import com.dainn.dao.impl.ReceiptDAO;
import com.dainn.dto.ReceiptDTO;
import com.dainn.service.IReceiptService;

public class ReceiptService implements IReceiptService {
    private IReceiptDAO receiptDAO;

    public ReceiptService() {
        this.receiptDAO = new ReceiptDAO();
    }

    @Override
    public ReceiptDTO save(ReceiptDTO dto) {
        Integer id = receiptDAO.save(dto);
        return receiptDAO.findById(id);
    }
}
