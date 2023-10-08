package com.dainn.dao;

import com.dainn.dto.CustomerDTO;
import com.dainn.dto.OrderDetailDTO;

import java.util.List;

public interface ICustomerDAO {
    CustomerDTO findByPhone(String phone, Integer status);
    CustomerDTO findById(Integer id);
    Integer save(CustomerDTO dto);
    void update(CustomerDTO dto);
}
