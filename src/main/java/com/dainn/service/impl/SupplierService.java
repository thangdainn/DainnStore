package com.dainn.service.impl;

import com.dainn.dao.ISupplierDAO;
import com.dainn.dao.impl.SupplierDAO;
import com.dainn.dto.SupplierDTO;
import com.dainn.service.ISupplierService;

import java.util.List;

public class SupplierService implements ISupplierService {
    private ISupplierDAO supplierDAO;

    public SupplierService() {
        this.supplierDAO = new SupplierDAO();
    }

    @Override
    public List<SupplierDTO> findAll() {
        List<SupplierDTO> list = supplierDAO.findAll();
        return list.isEmpty() ? null : list;
    }

}
