package com.dainn.service.impl;

import com.dainn.dao.IOrderDetailDAO;
import com.dainn.dao.impl.OrderDetailDAO;
import com.dainn.dto.OrderDetailDTO;
import com.dainn.service.IOrderDetailService;

import java.util.List;

public class OrderDetailService implements IOrderDetailService {
    private IOrderDetailDAO orderDetailDAO;

    public OrderDetailService() {
        this.orderDetailDAO = new OrderDetailDAO();
    }

    @Override
    public List<OrderDetailDTO> findAll() {
        List<OrderDetailDTO> list = orderDetailDAO.findAll();
        return list.isEmpty() ? null : list;
    }

    @Override
    public void save(OrderDetailDTO dto) {
        orderDetailDAO.save(dto);
    }
}
