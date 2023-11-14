package com.dainn.service;

import com.dainn.dto.StatisticDTO;

import java.sql.Timestamp;
import java.util.List;

public interface IStatisticService {
    List<StatisticDTO> findByCategory(Integer status);
    List<StatisticDTO> findByCategoryAndDate(Integer status, Timestamp fromDate, Timestamp toDate);
    List<StatisticDTO> findByProduct(Integer status);
    List<StatisticDTO> findByProductAndDate(Integer status, Timestamp fromDate, Timestamp toDate);
    List<StatisticDTO> findByAccount(Integer status);
    List<StatisticDTO> findByAccountAndDate(Integer status, Timestamp fromDate, Timestamp toDate);
}
