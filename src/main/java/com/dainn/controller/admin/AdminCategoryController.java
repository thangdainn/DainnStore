package com.dainn.controller.admin;

import com.dainn.dto.CategoryDTO;
import com.dainn.dto.ProductDTO;
import com.dainn.gui.AdminUI;
import com.dainn.utils.ImageUtil;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class AdminCategoryController implements MouseListener, ActionListener {
	private AdminUI adminUI;

	public AdminCategoryController(AdminUI adminUI) {
		this.adminUI = adminUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btn = e.getActionCommand();
		if (btn.equals("Thêm")) {
			handleAdd();
		} else if (btn.equals("Lưu")) {
			this.handleUpdate();
		} else if (btn.equals("Xóa")) {
			this.handleDelete();
		} else if (btn.equals("Xóa tất cả")) {
			this.handleDeleteAll();
		} else if (btn.equals("Làm mới")) {
			this.adminUI.handleFormCleanCate();
		} else if (btn.equals("Tìm")) {
			this.findByIdOrName();
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		int row = adminUI.table_category.getSelectedRow();
		adminUI.showCateDataToComponents(row);
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
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

	private CategoryDTO getCateDataFromComponents() {
		String name = this.adminUI.textField_cateName.getText().trim();
		String description = this.adminUI.textField_cateDescription.getText().trim();

		String error = "";
		if (name.isEmpty()) {
			error = "Nhập tên danh mục.";
		} else if (description.isEmpty()) {
			error = "Nhập mô tả.";
		}

		if (!error.equals("")) {
			JOptionPane.showMessageDialog(this.adminUI, error);
			return null;
		} else {
			CategoryDTO category = new CategoryDTO();
			category.setName(name);
			category.setDescription(description);
			return category;
		}
	}

	private void findByIdOrName() {
		String keyword = adminUI.textField_cateFind.getText();
		adminUI.showListCateToTable(adminUI.categoryService.findByIdOrNameContaining(keyword, 1));
	}

	private void handleDeleteAll() {
		int confirm = JOptionPane.showConfirmDialog(this.adminUI, "Bạn có chắc chắn xóa?", "Conform", JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_OPTION) {
			for (CategoryDTO category : adminUI.categoryService.findAll(1)){
				adminUI.categoryService.delete(category.getId());
			}
			adminUI.handleFormCleanCate();
			JOptionPane.showMessageDialog(this.adminUI, "Xóa tất cả danh mục thành công.");
		}
	}

	private void handleDelete() {
		if (this.adminUI.textField_cateId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this.adminUI, "Chọn danh mục để xóa.");
		} else {
			Integer id = Integer.valueOf(this.adminUI.textField_cateId.getText());
			int confirm = JOptionPane.showConfirmDialog(this.adminUI, "Bạn có chắc chắn xóa?", "Conform", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				adminUI.categoryService.delete(id);
				adminUI.handleFormCleanCate();
				JOptionPane.showMessageDialog(this.adminUI, "Xóa danh mục thành công.");
			}
		}
	}

	private void handleUpdate() {
		if (!this.adminUI.textField_cateId.getText().isEmpty()) {
			CategoryDTO category = getCateDataFromComponents();
			if (category != null) {
				Integer cateId = Integer.valueOf(this.adminUI.textField_cateId.getText());
				category.setId(cateId);
				adminUI.categoryService.update(category);
				adminUI.handleFormCleanCate();
				JOptionPane.showMessageDialog(this.adminUI, "Cập nhật danh mục thành công.");
			}
		} else {
			JOptionPane.showMessageDialog(this.adminUI, "Vui lòng chọn danh mục.");
		}
	}

	private void handleAdd() {
		CategoryDTO category = getCateDataFromComponents();
		if (category != null){
			if (this.adminUI.textField_cateId.getText().isEmpty()) {
				category = adminUI.categoryService.save(category);
				this.adminUI.addRowCategory(category);
				this.adminUI.formCleanCate();
				JOptionPane.showMessageDialog(this.adminUI, "Thêm danh mục thành công.");
			} else {
				JOptionPane.showMessageDialog(this.adminUI, "Chọn làm mới trước khi thêm.");
			}
		}
	}
}
