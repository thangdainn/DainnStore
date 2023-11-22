package com.dainn.service.impl;

import com.dainn.dao.IReceiptDAO;
import com.dainn.dao.impl.ReceiptDAO;
import com.dainn.dto.ReceiptDTO;
import com.dainn.service.IReceiptService;

import java.util.List;

public class ReceiptService implements IReceiptService {
    private IReceiptDAO receiptDAO;

    public ReceiptService() {
        this.receiptDAO = new ReceiptDAO();
    }

    @Override
    public ReceiptDTO save(ReceiptDTO dto) {
        Integer id = receiptDAO.save(dto);
        return receiptDAO.findById(id, 1);
    }

    @Override
    public ReceiptDTO update(ReceiptDTO dto) {
        receiptDAO.update(dto);
        return receiptDAO.findById(dto.getId(), 1);
    }

    @Override
    public void delete(Integer id) {
        receiptDAO.delete(id);
    }

    @Override
    public List<ReceiptDTO> findAll(Integer status) {
        List<ReceiptDTO> list = receiptDAO.findByStatus(status);
        return list.isEmpty() ? null : list;
    }

    @Override
    public ReceiptDTO findById(Integer id, Integer status) {
        return receiptDAO.findById(id, status);
    }

    @Override
    public List<ReceiptDTO> findByKeyword(String keyword, Integer status) {
        List<ReceiptDTO> list = receiptDAO.findByKeyword(keyword, status);
        return list.isEmpty() ? null : list;
    }

    @Override
    public List<ReceiptDTO> findByMonth(Integer month, Integer status) {
        List<ReceiptDTO> list = receiptDAO.findByMonth(month, status);
        return list.isEmpty() ? null : list;
    }
}
