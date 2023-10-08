package com.dainn.dao.impl;

import com.dainn.dao.IOrderDetailDAO;
import com.dainn.dto.OrderDetailDTO;
import com.dainn.mapper.OrderDetailMapper;

import java.util.List;


public class OrderDetailDAO extends AbstractDAO<OrderDetailDTO> implements IOrderDetailDAO {

    @Override
    public List<OrderDetailDTO> findAll() {
        String sql = "SELECT * FROM orderdetail";
        return query(sql, new OrderDetailMapper());
    }

    @Override
    public void save(OrderDetailDTO dto) {
        String sql = "INSERT INTO orderdetail(order_id, product_id, rom_id, quantity, price) VALUES(?,?,?,?,?)";
        update(sql, dto.getOrderId(), dto.getProductId(), dto.getRomId(), dto.getQuantity(), dto.getPrice());
    }

}
