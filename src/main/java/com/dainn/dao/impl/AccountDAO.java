package com.dainn.dao.impl;

import com.dainn.dao.IAccountDAO;
import com.dainn.dto.AccountDTO;
import com.dainn.mapper.AccountMapper;

import java.util.List;

public class AccountDAO extends AbstractDAO<AccountDTO> implements IAccountDAO {
    @Override
    public AccountDTO findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        String sql = "SELECT * FROM account WHERE username = ? AND password = ? AND status = ?";
        List<AccountDTO> accounts = query(sql, new AccountMapper(), userName, password, status);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public AccountDTO findByUserName(String userName) {
        String sql = "SELECT * FROM account WHERE username = ?";
        List<AccountDTO> accounts = query(sql, new AccountMapper(), userName);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Integer save(AccountDTO accountDTO) {
        String sql = "INSERT INTO account(username, password, fullname, phone, address, status, role_id) VALUES (?,?,?,?,?,?,?)";
        return insert(sql, accountDTO.getUsername(), accountDTO.getPassword(), accountDTO.getFullName(), accountDTO.getPhone(),
                accountDTO.getAddress(), accountDTO.getStatus(), accountDTO.getRoleId());
    }

    @Override
    public AccountDTO findOne(Integer id) {
        String sql = "SELECT * FROM account WHERE id = ?";
        List<AccountDTO> accounts = query(sql, new AccountMapper(), id);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public void update(AccountDTO accountUpdate) {
        String sql = "UPDATE account SET username=?,password=?,fullname=?,phone=?,address=?,status=?,role_id=? WHERE id=?";
        update(sql, accountUpdate.getUsername(), accountUpdate.getPassword(), accountUpdate.getFullName(), accountUpdate.getPhone(),
                accountUpdate.getAddress(), accountUpdate.getStatus(), accountUpdate.getRoleId(), accountUpdate.getId());
    }
}
