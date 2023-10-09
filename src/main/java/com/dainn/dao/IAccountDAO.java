package com.dainn.dao;

import com.dainn.dto.AccountDTO;

public interface IAccountDAO {
    AccountDTO findByUserNameAndPassword(String userName, String password, Integer status);
    AccountDTO findByUserName(String userName, Integer status);
    Integer save(AccountDTO accountDTO);
    AccountDTO findById(Integer id, Integer status);
    void update(AccountDTO accountUpdate);
}
