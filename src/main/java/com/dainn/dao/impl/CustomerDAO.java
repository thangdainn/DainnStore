package com.dainn.dao.impl;

import com.dainn.dao.ICustomerDAO;
import com.dainn.dto.CustomerDTO;
import com.dainn.mapper.CustomerMapper;

import java.util.List;

public class CustomerDAO extends AbstractDAO<CustomerDTO> implements ICustomerDAO {


    @Override
    public CustomerDTO findByPhone(String phone, Integer status) {
        String sql = "SELECT * FROM customer WHERE phone = ? AND status = ?";
        List<CustomerDTO> list = query(sql, new CustomerMapper(), phone, status);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public CustomerDTO findById(Integer id) {
        String sql = "SELECT * FROM customer WHERE id = ?";
        List<CustomerDTO> list = query(sql, new CustomerMapper(), id);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public Integer save(CustomerDTO dto) {
        String sql = "INSERT INTO customer(fullname, address, phone) VALUES(?,?,?)";
        return insert(sql, dto.getName(), dto.getAddress(), dto.getPhone());
    }

    @Override
    public void update(CustomerDTO dto) {
        String sql = "UPDATE customer SET fullname = ?, address = ?, phone= ?, points= ?, status = ? WHERE id = ?";
        update(sql, dto.getName(), dto.getAddress(), dto.getPhone(), dto.getPoints(), dto.getStatus(), dto.getId());
    }
}
