package com.dainn.dao.impl;

import com.dainn.dao.ISupplierDAO;
import com.dainn.dto.SupplierDTO;
import com.dainn.mapper.SupplierMapper;

import java.util.List;


public class SupplierDAO extends AbstractDAO<SupplierDTO> implements ISupplierDAO {

    @Override
    public List<SupplierDTO> findAll() {
        String sql = "SELECT * FROM supplier";
        return query(sql, new SupplierMapper());
    }

    @Override
    public SupplierDTO findByName(String name) {
        String sql = "SELECT * FROM supplier WHERE name = ?";
        List<SupplierDTO> list = query(sql, new SupplierMapper(), name);
        return list.isEmpty() ? null : list.get(0);
    }

}
