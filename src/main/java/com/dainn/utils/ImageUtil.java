package com.dainn.utils;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImageUtil {
    public static void scaleImage(String path, JLabel label) {
        ImageIcon icon = new ImageIcon("src/main/resources" + path);
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        label.setIcon(scaledIcon);
    }
    public static String selectImg(JFrame frame, JLabel label) {
        String imgPath = null;
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("src/main/resources"));
        int returnVal = fc.showOpenDialog(frame);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String fileName = file.getName();
            if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                String resourcePath = "src/main/resources";
                int lengthResourcePath = resourcePath.length();
                String absolutePath = file.getAbsolutePath();
                absolutePath = absolutePath.replace(File.separator, "/");
                imgPath = absolutePath.substring(absolutePath.lastIndexOf(resourcePath) + lengthResourcePath);
                scaleImage(imgPath, label);
            } else {
                JOptionPane.showMessageDialog(frame, "File ảnh không đúng định dạng");
            }
        }
        System.out.println(imgPath);
        return imgPath;
    }
}
