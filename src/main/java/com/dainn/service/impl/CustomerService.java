package com.dainn.service.impl;

import com.dainn.dao.ICustomerDAO;
import com.dainn.dao.impl.CustomerDAO;
import com.dainn.dto.CustomerDTO;
import com.dainn.service.ICustomerService;

public class CustomerService implements ICustomerService {
    private ICustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    @Override
    public CustomerDTO findByPhone(String phone, Integer status) {
        return customerDAO.findByPhone(phone, status);
    }

    @Override
    public CustomerDTO save(CustomerDTO dto) {
        Integer id = customerDAO.save(dto);
        return customerDAO.findById(id);
    }

    @Override
    public void update(CustomerDTO dto) {
        customerDAO.update(dto);
    }
}
