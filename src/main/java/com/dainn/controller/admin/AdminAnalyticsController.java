package com.dainn.controller.admin;

import com.dainn.dto.StatisticDTO;
import com.dainn.gui.AdminUI;
import com.dainn.gui.ChartUI;
import com.dainn.service.IStatisticService;
import com.dainn.service.impl.StatisticService;
import com.toedter.calendar.JDateChooser;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
		} else if (action.equals("Xuất thống kê")){
			if (AdminUI.currentStatistic == 0){
				handleExport(adminUI.table_analyticCate);
			} else if (AdminUI.currentStatistic == 1){
				handleExport(adminUI.table_analyticProduct);
			} else if (AdminUI.currentStatistic == 2){
				handleExport(adminUI.table_analyticEmployee);
			}
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
		if (AdminUI.currentStatistic == 0){
			adminUI.statistics = statisticService.findByCategoryAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticCate.getModel();
		} else if (AdminUI.currentStatistic == 1){
			adminUI.statistics = statisticService.findByProductAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticProduct.getModel();
		} else if (AdminUI.currentStatistic == 2){
			adminUI.statistics = statisticService.findByAccountAndDate(1, new Timestamp(fromDate.getTime()), new Timestamp(toDate.getTime()));
			tableModel = (DefaultTableModel) adminUI.table_analyticEmployee.getModel();
		}
		adminUI.showAnalyticCToTable(adminUI.statistics, tableModel);
	}

	private void handleExport(JTable table){
		try{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showSaveDialog(adminUI);
			File saveFile = fileChooser.getSelectedFile();
			if (saveFile != null){
				saveFile = new File(saveFile.toString() + ".xlsx");
				Workbook wb = new XSSFWorkbook();
				Sheet sheet = wb.createSheet("data");

				Row rowCol = sheet.createRow(0);
				for (int i = 0; i < table.getColumnCount(); i++) {
					Cell cell = rowCol.createCell(i);
					cell.setCellValue(table.getColumnName(i));
				}

				for (int i = 0; i < table.getRowCount(); i++) {
					Row row = sheet.createRow(i + 1);
					for (int j = 0; j < table.getColumnCount(); j++) {
						Cell cell = row.createCell(j);
						if (table.getValueAt(i, j) != null){
							cell.setCellValue(table.getValueAt(i, j).toString());
						}
					}
				}
				FileOutputStream output = new FileOutputStream(new File(saveFile.toString()));
				wb.write(output);
				wb.close();
				output.close();
				openFile(saveFile.toString());
			}
		} catch (IOException e){
			System.out.println(e);
		}
	}

	public void openFile(String file){
		try{
			File path = new File(file);
			Desktop.getDesktop().open(path);
		} catch (IOException e){
			System.out.println(e);
		}
	}
}
