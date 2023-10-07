package com.dainn.utils;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberTextField {
    public static void numberTextField(JTextField textField){
        // Tạo DocumentFilter để chỉ cho phép nhập số
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (containsOnlyNumbers(text)) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (containsOnlyNumbers(text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean containsOnlyNumbers(String text) {
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isDigit(text.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        });
    }

    public static void numberTextFieldStartWithoutZero(JTextField textField) {
        // Tạo DocumentFilter để chỉ cho phép nhập số và không bắt đầu bằng 0
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (isValidInput(text, fb.getDocument().getText(0, fb.getDocument().getLength()))) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (isValidInput(text, fb.getDocument().getText(0, fb.getDocument().getLength()))) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isValidInput(String text, String currentText) {
                // Kiểm tra nếu đầu tiên là số 0 và không có ký tự khác trước số 0 thì không cho phép
                if (text.equals("0") && currentText.length() == 0) {
                    return false;
                }

                // Kiểm tra nếu text chỉ chứa số
                for (int i = 0; i < text.length(); i++) {
                    if (!Character.isDigit(text.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
        });
    }
}
