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
    public AccountDTO findByUserNameAndPassword(String userName, String password, Integer status) {
        return accountDAO.findByUserNameAndPassword(userName, password, status);
    }

    @Override
    public AccountDTO findByUserName(String userName, Integer status) {
        return accountDAO.findByUserName(userName, status);
    }

    @Override
    public AccountDTO save(AccountDTO accountDTO) {
        Integer id = accountDAO.save(accountDTO);
        return accountDAO.findById(id, 1);
    }

    @Override
    public AccountDTO update(AccountDTO accountUpdate) {
        Integer id = accountUpdate.getId();
        accountDAO.update(accountUpdate);
        return accountDAO.findById(id, 1);
    }

}
