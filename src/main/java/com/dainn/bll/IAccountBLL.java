package com.dainn.bll;

import com.dainn.bll.impl.AccountBLL;
import com.dainn.dto.AccountDTO;

public interface IAccountBLL {
    AccountDTO findByUserNameAndPasswordAndStatus(String userName, String password, Integer status);
    AccountDTO findByUserName(String userName);
    AccountDTO save(AccountDTO accountDTO);
    AccountDTO update(AccountDTO accountUpdate);
}
