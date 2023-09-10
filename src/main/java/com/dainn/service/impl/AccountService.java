package com.dainn.service.impl;

import com.dainn.service.IAccountService;
import com.dainn.dao.IAccountDAO;
import com.dainn.dao.impl.AccountDAO;
import com.dainn.dto.AccountDTO;

public class AccountService implements IAccountService {

    private IAccountDAO accountDAO;

    public AccountService() {
        this.accountDAO = new AccountDAO();
    }

    @Override
    public AccountDTO findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
        return accountDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
    }

    @Override
    public AccountDTO findByUserName(String userName) {
        return accountDAO.findByUserName(userName);
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        Integer id = accountDAO.save(accountDTO);
        return accountDAO.findOne(id);
    }

    @Override
    public AccountDTO update(AccountDTO accountUpdate) {
        return null;
    }

}
