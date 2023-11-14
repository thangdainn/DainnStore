package com.dainn.dao;

import com.dainn.dto.CategoryDTO;
import com.dainn.dto.StatisticDTO;

import java.sql.Timestamp;
import java.util.List;

public interface IStatisticDAO {
    List<StatisticDTO> findByCategory(Integer status);
    List<StatisticDTO> findByCategoryAndDate(Integer status, Timestamp fromDate, Timestamp toDate);
    List<StatisticDTO> findByProduct(Integer status);
    List<StatisticDTO> findByProductAndDate(Integer status, Timestamp fromDate, Timestamp toDate);
    List<StatisticDTO> findByAccount(Integer status);
    List<StatisticDTO> findByAccountAndDate(Integer status, Timestamp fromDate, Timestamp toDate);
}
