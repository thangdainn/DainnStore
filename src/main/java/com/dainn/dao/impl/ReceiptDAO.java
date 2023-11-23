package com.dainn.dao.impl;

import com.dainn.dao.IReceiptDAO;
import com.dainn.dto.ReceiptDTO;
import com.dainn.mapper.ReceiptMapper;

import java.util.List;


public class ReceiptDAO extends AbstractDAO<ReceiptDTO> implements IReceiptDAO {


    @Override
    public Integer save(ReceiptDTO dto) {
        String sql = "INSERT INTO receipt(supplier_id, account_id, totalprice) VALUES(?,?,?)";
        return insert(sql, dto.getSupplierId(), dto.getAccountId(), dto.getTotalPrice());
    }

    @Override
    public void update(ReceiptDTO dto) {
        String sql = "UPDATE receipt SET supplier_id = ? WHERE id = ?";
        update(sql, dto.getSupplierId(), dto.getId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "UPDATE receipt SET status = 0 WHERE id = ?";
        update(sql, id);
    }

    @Override
    public ReceiptDTO findById(Integer id, Integer status) {
        String sql = "SELECT * FROM receipt WHERE id = ? AND status = ?";
        List<ReceiptDTO> list = query(sql, new ReceiptMapper(), id, status);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<ReceiptDTO> findByStatus(Integer status) {
        String sql = "SELECT * FROM receipt WHERE status = ?";
        return query(sql, new ReceiptMapper(), status);
    }

    @Override
    public List<ReceiptDTO> findByKeyword(String keyword, Integer status) {
        keyword = "%" + keyword + "%";
        String sql = "SELECT * FROM receipt WHERE id LIKE ? OR supplier_id LIKE ? OR account_id LIKE ? AND status = ?";
        return query(sql, new ReceiptMapper(), keyword, keyword, keyword, status);
    }

    @Override
    public List<ReceiptDTO> findByMonth(Integer month, Integer status) {
        String sql = "SELECT * FROM `receipt` WHERE MONTH(createddate) = ? AND status = ?";
        return query(sql, new ReceiptMapper(), month, status);
    }
}
