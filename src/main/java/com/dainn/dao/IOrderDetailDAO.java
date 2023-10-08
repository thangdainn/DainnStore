package com.dainn.dao;

import com.dainn.dto.OrderDetailDTO;
import com.dainn.dto.ProductDTO;

import java.util.List;

public interface IOrderDetailDAO {
    List<OrderDetailDTO> findAll();
    void save(OrderDetailDTO dto);
}
