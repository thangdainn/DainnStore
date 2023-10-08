package com.dainn.dao;

import com.dainn.dao.impl.OrderDAO;
import com.dainn.dto.CustomerDTO;
import com.dainn.dto.OrderDTO;
import com.dainn.dto.OrderDetailDTO;

import java.util.List;

public interface IOrderDAO {
    Integer save(OrderDTO dto);
    OrderDTO findById(Integer id);
}
