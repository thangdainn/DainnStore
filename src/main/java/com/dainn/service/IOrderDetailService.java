package com.dainn.service;

import com.dainn.dto.OrderDetailDTO;

import java.util.List;

public interface IOrderDetailService {
    List<OrderDetailDTO> findAll();
    void save(OrderDetailDTO dto);
}
