package com.dainn.service.impl;

import com.dainn.dao.IOrderDAO;
import com.dainn.dao.impl.OrderDAO;
import com.dainn.dto.OrderDTO;
import com.dainn.service.IOrderService;

public class OrderService implements IOrderService {
    private IOrderDAO orderDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
    }

    @Override
    public OrderDTO save(OrderDTO dto) {
        Integer id = orderDAO.save(dto);
        return orderDAO.findById(id);
    }
}
