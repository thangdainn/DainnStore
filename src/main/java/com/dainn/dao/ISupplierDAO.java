package com.dainn.dao;

import com.dainn.dto.OrderDetailDTO;
import com.dainn.dto.SupplierDTO;

import java.util.List;

public interface ISupplierDAO {
    List<SupplierDTO> findAll();
}
