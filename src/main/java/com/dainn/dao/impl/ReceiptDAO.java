package com.dainn.dao.impl;

import com.dainn.dao.IReceiptDAO;
import com.dainn.dao.ISupplierDAO;
import com.dainn.dto.ReceiptDTO;
import com.dainn.dto.SupplierDTO;
import com.dainn.mapper.ReceiptMapper;
import com.dainn.mapper.SupplierMapper;

import java.util.List;


public class ReceiptDAO extends AbstractDAO<ReceiptDTO> implements IReceiptDAO {


    @Override
    public Integer save(ReceiptDTO dto) {
        String sql = "INSERT INTO receipt(supplier_id, account_id, totalprice) VALUES(?,?,?)";
        return insert(sql, dto.getSupplierId(), dto.getAccountId(), dto.getTotalPrice());
    }

    @Override
    public ReceiptDTO findById(Integer id) {
        String sql = "SELECT * FROM receipt WHERE id = ?";
        List<ReceiptDTO> list = query(sql, new ReceiptMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }
}
