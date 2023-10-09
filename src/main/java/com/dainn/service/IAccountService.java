package com.dainn.service;

import com.dainn.dto.AccountDTO;

public interface IAccountService {
    AccountDTO findByUserNameAndPassword(String userName, String password, Integer status);
    AccountDTO findByUserName(String userName);
    AccountDTO save(AccountDTO accountDTO);
    AccountDTO update(AccountDTO accountUpdate);
}
