package com.dainn.service;

import com.dainn.dto.SupplierDTO;

import java.util.List;

public interface ISupplierService {
    List<SupplierDTO> findAll();
    SupplierDTO findByName(String name);
}
