package com.dainn.dao.impl;

import com.dainn.dao.IOrderDAO;
import com.dainn.dto.OrderDTO;
import com.dainn.mapper.OrderMapper;

import java.util.List;

public class OrderDAO extends AbstractDAO<OrderDTO> implements IOrderDAO {


    @Override
    public Integer save(OrderDTO dto) {
        String sql = "INSERT INTO `order`(totalprice, account_id, customer_id) VALUES(?,?,?)";
        return insert(sql, dto.getTotalPrice(), dto.getAccountId(), dto.getCustomerId());
    }

    @Override
    public OrderDTO findById(Integer id) {
        String sql = "SELECT * FROM `order` WHERE id = ?";
        List<OrderDTO> list = query(sql, new OrderMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }
}
