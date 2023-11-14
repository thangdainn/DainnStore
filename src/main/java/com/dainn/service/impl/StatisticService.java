package com.dainn.service.impl;

import com.dainn.dao.IStatisticDAO;
import com.dainn.dao.impl.StatisticDAO;
import com.dainn.dto.StatisticDTO;
import com.dainn.service.IStatisticService;

import java.sql.Timestamp;
import java.util.List;

public class StatisticService implements IStatisticService {
    private IStatisticDAO statisticDAO;

    public StatisticService() {
        this.statisticDAO = new StatisticDAO();
    }

    @Override
    public List<StatisticDTO> findByCategory(Integer status) {
        List<StatisticDTO> statistics = statisticDAO.findByCategory(status);
        return statistics.isEmpty() ? null : statistics;
    }

    @Override
    public List<StatisticDTO> findByCategoryAndDate(Integer status, Timestamp fromDate, Timestamp toDate) {
        List<StatisticDTO> statistics = statisticDAO.findByCategoryAndDate(status, fromDate, toDate);
        return statistics.isEmpty() ? null : statistics;
    }

    @Override
    public List<StatisticDTO> findByProduct(Integer status) {
        List<StatisticDTO> statistics = statisticDAO.findByProduct(status);
        return statistics.isEmpty() ? null : statistics;
    }

    @Override
    public List<StatisticDTO> findByProductAndDate(Integer status, Timestamp fromDate, Timestamp toDate) {
        List<StatisticDTO> statistics = statisticDAO.findByProductAndDate(status, fromDate, toDate);
        return statistics.isEmpty() ? null : statistics;
    }

    @Override
    public List<StatisticDTO> findByAccount(Integer status) {
        List<StatisticDTO> statistics = statisticDAO.findByAccount(status);
        return statistics.isEmpty() ? null : statistics;
    }

    @Override
    public List<StatisticDTO> findByAccountAndDate(Integer status, Timestamp fromDate, Timestamp toDate) {
        List<StatisticDTO> statistics = statisticDAO.findByAccountAndDate(status, fromDate, toDate);
        return statistics.isEmpty() ? null : statistics;
    }
}
