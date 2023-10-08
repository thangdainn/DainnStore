package com.dainn.service;

import com.dainn.dto.CustomerDTO;

public interface ICustomerService {
    CustomerDTO findByPhone(String phone, Integer status);
    CustomerDTO save(CustomerDTO dto);
    void update(CustomerDTO dto);
}
