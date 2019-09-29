package com;

import javax.swing.*;

import com.views.TemperatureView;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.out.println("Error");
            }

            TemperatureView view = new TemperatureView();
            view.showGUI();
        });
    }
}