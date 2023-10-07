package com.dainn.dao.impl;

import com.dainn.dao.IOrderDetailDAO;
import com.dainn.dao.IProductDAO;
import com.dainn.dto.OrderDetailDTO;
import com.dainn.dto.ProductDTO;
import com.dainn.mapper.OrderDetailMapper;
import com.dainn.mapper.ProductMapper;

import java.util.List;

public class OrderDetailDAO extends AbstractDAO<OrderDetailDTO> implements IOrderDetailDAO {

    @Override
    public List<OrderDetailDTO> findAll() {
        String sql = "SELECT * FROM orderdetail";
        return query(sql, new OrderDetailMapper());
    }

}
