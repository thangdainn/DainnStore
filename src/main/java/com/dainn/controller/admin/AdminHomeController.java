package com.dainn.controller.admin;

import com.dainn.gui.AdminUI;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AdminHomeController implements MouseListener, ActionListener {
	private AdminUI adminUI;

	public AdminHomeController(AdminUI adminUI) {
		this.adminUI = adminUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		this.adminUI.handleSetColor(panel);
		this.adminUI.handleShowCart(panel);
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {

	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		panel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.adminUI.setColor(panel);
	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		JPanel panel = (JPanel) e.getSource();
		panel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		if(!this.adminUI.currentJPanel.equals(panel)) {
			this.adminUI.resetColor(panel);
		}
	}
}
