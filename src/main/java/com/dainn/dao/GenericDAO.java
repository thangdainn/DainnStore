package com.dainn.dao;

import com.dainn.mapper.IRowMapper;

import java.util.List;

public interface GenericDAO<T> {
    List<T> query(String sql, IRowMapper<T> rowMapper, Object... parameters);
    Integer insert(String sql, Object... parameters);
    void update(String sql, Object... parameters);
}
