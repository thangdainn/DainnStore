package com.dainn.controller.admin;

import com.dainn.dto.StatisticDTO;
import com.dainn.gui.AdminUI;
import com.dainn.gui.ChartUI;
import com.dainn.service.IStatisticService;
import com.dainn.service.impl.StatisticService;
import com.toedter.calendar.JDateChooser;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AdminAnalyticsController implements MouseListener, ActionListener, PropertyChangeListener {
	private AdminUI adminUI;
	private IStatisticService statisticService = new StatisticService();

	public AdminAnalyticsController(AdminUI adminUI) {
		this.adminUI = adminUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Xem biểu đồ")){
			new ChartUI(adminUI.statistics);
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	@SneakyThrows
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		JButton button = (JButton) e.getSource();
		this.adminUI.handleShowCartAnalytics(button);
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("date".equals(evt.getPropertyName())){
			handleShowAnalyticDate();
		}
	}

	private void handleShowAnalyticDate(){
//		List<StatisticDTO> list = new ArrayList<>();
		Date fromDate = adminUI.fromDateChooser.getDate();
		Date toDate = adminUI.toDateChooser.getDate();
		if (fromDate == null){
			fromDate = new Date("0000-01-01");
		} else if (toDate == null){
			toDate = new Date();
		}
		DefaultTableModel tableModel = null;
		if (adminUI.currentStatistic == 0){
			adminUI.statistics = statisticService.findByCategoryAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticCate.getModel();
		} else if (adminUI.currentStatistic == 1){
			adminUI.statistics = statisticService.findByProductAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticProduct.getModel();
		} else if (adminUI.currentStatistic == 2){
			adminUI.statistics = statisticService.findByAccountAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticEmployee.getModel();
		}
		adminUI.showAnalyticCToTable(adminUI.statistics, tableModel);
	}


}
