package com.dainn.controller.admin;

import com.dainn.dto.StatisticDTO;
import com.dainn.gui.AdminUI;
import com.dainn.service.IStatisticService;
import com.dainn.service.impl.StatisticService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class AdminAnalyticsController implements MouseListener, ActionListener {
	private AdminUI adminUI;
	private IStatisticService statisticService = new StatisticService();

	public AdminAnalyticsController(AdminUI adminUI) {
		this.adminUI = adminUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		Object source = e.getSource();
		if (source == this.adminUI.fromDateChooser || source == this.adminUI.toDateChooser){
			handleShowAnalyticDate();
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

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

	private void handleShowAnalyticDate(){
		List<StatisticDTO> list = new ArrayList<>();
		Date fromDate = adminUI.fromDateChooser.getDate();
		Date toDate = adminUI.toDateChooser.getDate();
		DefaultTableModel tableModel = null;
		if (adminUI.currentStatistic == 0){
			list = statisticService.findByCategoryAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticCate.getModel();
		} else if (adminUI.currentStatistic == 1){
			list = statisticService.findByProductAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticCate.getModel();
		} else if (adminUI.currentStatistic == 2){
			list = statisticService.findByProductAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticCate.getModel();
		}

//		adminUI.showAnalyticCToTable(list, tableModel);
	}
}
