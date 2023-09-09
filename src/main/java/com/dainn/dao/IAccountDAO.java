package com.dainn.dao;

import com.dainn.dto.AccountDTO;

public interface IAccountDAO {
    AccountDTO findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    AccountDTO findByUserName(String userName);
    Integer save(AccountDTO accountDTO);
    AccountDTO findOne(Integer id);
    void update(AccountDTO accountUpdate);
}
