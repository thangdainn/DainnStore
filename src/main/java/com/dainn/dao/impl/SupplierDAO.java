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

}
