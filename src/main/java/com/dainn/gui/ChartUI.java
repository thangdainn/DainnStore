package com.dainn.gui;

import com.dainn.dto.StatisticDTO;
import raven.chart.ModelChart;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class ChartUI extends JFrame {
    private raven.chart.CurveLineChart chart;
    private raven.panel.PanelShadow panelShadow1;

    public ChartUI(List<StatisticDTO> list) {
        initComponents();
        chart.setTitle("Chart Data");
        chart.addLegend("Amount 1", Color.decode("#7b4397"), Color.decode("#dc2430"));
        setData(list);
        setVisible(true);
    }

    private void app() {
        chart.clear();
        chart.addData(new ModelChart("January", new double[]{500, 50, 100}));
        chart.addData(new ModelChart("February", new double[]{600, 300, 150}));
        chart.addData(new ModelChart("March", new double[]{200, 50, 900}));
        chart.addData(new ModelChart("April", new double[]{480, 700, 100}));
        chart.addData(new ModelChart("May", new double[]{350, 540, 500}));
        chart.addData(new ModelChart("June", new double[]{450, 800, 100}));
        chart.start();
    }

    private void setData(List<StatisticDTO> list) {
        if (list.size() > 10){
            list.sort(Comparator.comparingInt(StatisticDTO::getTotalPrice).reversed());
            int limit = Math.min(10, list.size());
            list.subList(limit, list.size()).clear();
        }
        //  Add Data to chart
        for (int i = list.size() - 1; i >= 0; i--) {
            StatisticDTO d = list.get(i);

            chart.addData(new ModelChart(d.getName(), new double[]{d.getTotalPrice()}));
        }
        //  Start to show data with animation
        chart.start();
    }

    private void initComponents() {

        panelShadow1 = new raven.panel.PanelShadow();
        chart = new raven.chart.CurveLineChart();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelShadow1.setBackground(new java.awt.Color(34, 59, 69));
        panelShadow1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelShadow1.setColorGradient(new java.awt.Color(17, 38, 47));

        chart.setForeground(new java.awt.Color(237, 237, 237));
        chart.setFillColor(true);

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
                panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
                                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
                panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(chart, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

}
