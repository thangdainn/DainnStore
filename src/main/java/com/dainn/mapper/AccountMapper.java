package com.dainn.mapper;

import com.dainn.dto.AccountDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountMapper implements IRowMapper<AccountDTO>{

    @Override
    public AccountDTO mapRow(ResultSet rs) {
        try {
            AccountDTO accountDTO = new AccountDTO();
            accountDTO.setId(rs.getInt("id"));
            accountDTO.setUsername(rs.getString("username"));
            accountDTO.setPassword(rs.getString("password"));
            accountDTO.setFullName(rs.getString("fullname"));
            accountDTO.setPhone(rs.getString("phone"));
            accountDTO.setAddress(rs.getString("address"));
            accountDTO.setStatus(rs.getInt("status"));
            accountDTO.setRoleId(rs.getString("role_id"));
            return accountDTO;
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
