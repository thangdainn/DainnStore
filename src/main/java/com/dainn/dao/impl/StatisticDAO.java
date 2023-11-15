package com.dainn.dao.impl;

import com.dainn.dao.IStatisticDAO;
import com.dainn.dto.StatisticDTO;
import com.dainn.mapper.StatisticMapper;

import java.sql.Timestamp;
import java.util.List;

public class StatisticDAO extends AbstractDAO<StatisticDTO> implements IStatisticDAO {

    @Override
    public List<StatisticDTO> findByCategory(Integer status) {
        String sql = "SELECT c.name, SUM(od.quantity) AS totalQty, SUM(od.price) AS totalPrice" +
                " FROM orderdetail od INNER JOIN product p ON p.id = od.product_id INNER JOIN category c ON c.id = p.category_id" +
                " WHERE c.status = ? GROUP BY c.name";
        return query(sql, new StatisticMapper(), status);
    }

    @Override
    public List<StatisticDTO> findByCategoryAndDate(Integer status, Timestamp fromDate, Timestamp toDate) {
        String sql = "SELECT c.name, SUM(od.quantity) AS totalQty, SUM(od.price) AS totalPrice" +
                " FROM orderdetail od INNER JOIN product p ON p.id = od.product_id INNER JOIN category c ON c.id = p.category_id" +
                " INNER JOIN `order` o ON o.id = od.order_id" +
                " WHERE c.status = ? AND o.createddate >= ? AND o.createddate <= ? GROUP BY c.name";
        return query(sql, new StatisticMapper(), status, fromDate, toDate);
    }

    @Override
    public List<StatisticDTO> findByProduct(Integer status) {
        String sql = "SELECT p.name, SUM(od.quantity) AS totalQty, SUM(od.price) AS totalPrice" +
                " FROM orderdetail od INNER JOIN product p ON p.id = od.product_id" +
                " WHERE p.status = ? GROUP BY p.name";
        return query(sql, new StatisticMapper(), status);
    }

    @Override
    public List<StatisticDTO> findByProductAndDate(Integer status, Timestamp fromDate, Timestamp toDate) {
        String sql = "SELECT p.name, SUM(od.quantity) AS totalQty, SUM(od.price) AS totalPrice" +
                " FROM orderdetail od INNER JOIN product p ON p.id = od.product_id" +
                " INNER JOIN `order` o ON o.id = od.order_id" +
                " WHERE p.status = ? AND o.createddate >= ? AND o.createddate <= ? GROUP BY p.name";
        return query(sql, new StatisticMapper(), status, fromDate, toDate);
    }

    @Override
    public List<StatisticDTO> findByAccount(Integer status) {
        String sql = "SELECT a.username AS name, SUM(od.quantity) AS totalQty, SUM(od.price) AS totalPrice" +
                " FROM orderdetail od INNER JOIN `order` o ON o.id = od.order_id INNER JOIN account a ON a.id = o.account_id" +
                " WHERE a.status = ? GROUP BY a.username";
        return query(sql, new StatisticMapper(), status);
    }

    @Override
    public List<StatisticDTO> findByAccountAndDate(Integer status, Timestamp fromDate, Timestamp toDate) {
        String sql = "SELECT a.username AS name, SUM(od.quantity) AS totalQty, SUM(od.price) AS totalPrice" +
                " FROM orderdetail od INNER JOIN `order` o ON o.id = od.order_id INNER JOIN account a ON a.id = o.account_id" +
                " WHERE a.status = ? AND o.createddate >= ? AND o.createddate <= ? GROUP BY a.username";
        return query(sql, new StatisticMapper(), status, fromDate, toDate);
    }
}
