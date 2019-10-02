package com.views;

import javax.swing.*;
import java.awt.*;

import com.controllers.TemperatureController;

public class TemperatureView extends JFrame {
    private JTextField input;
    private JTextField result;

    private JComboBox<String> leftSelect;
    private JComboBox<String> rightSelect;

    private GridBagConstraints constraints;

    public TemperatureView() {
        super("Перевод температур");

        constraints = setConstraints();

        int width = 400;
        int height = 200;

        setSize(width, height);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(createGUI());
    }

    public void showGUI() {
        setVisible(true);
    }

    private JPanel createGUI() {
        JPanel panel = new JPanel(new GridBagLayout());

        input = new JTextField(15);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(input, constraints);

        JLabel equally = new JLabel("=");
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(equally, constraints);

        result = new JTextField(15);
        result.setEditable(false);
        constraints.gridx = 2;
        constraints.gridy = 0;
        panel.add(result, constraints);

        String[] items = {"Цельсия", "Кельвина", "Фаренгейта"};

        leftSelect = new JComboBox<>(items);
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(leftSelect, constraints);

        rightSelect = new JComboBox<>(items);
        constraints.gridx = 2;
        constraints.gridy = 1;
        panel.add(rightSelect, constraints);

        JButton convertButton = new JButton("Перевести");
        constraints.gridx = 2;
        constraints.gridy = 2;
        panel.add(convertButton, constraints);

        convertButton.addActionListener(e -> {
            if (TemperatureController.isNumber(input.getText()) && leftSelect.getSelectedItem() != null && rightSelect.getSelectedItem() != null) {
                double enteredDegrees = Double.parseDouble(input.getText());

                String leftDegreeScale = (String) leftSelect.getSelectedItem();
                String rightDegreeScale = (String) rightSelect.getSelectedItem();

                String convertedDegrees = TemperatureController.callModelMethod(enteredDegrees, leftDegreeScale, rightDegreeScale);

                result.setText(convertedDegrees);
            } else {
                JOptionPane.showMessageDialog(panel, "Введите число");
            }
        });

        return panel;
    }

    private GridBagConstraints setConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.anchor = GridBagConstraints.PAGE_START;
        constraints.fill = GridBagConstraints.NONE;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.ipadx = 1;
        constraints.ipady = 1;
        constraints.insets = new Insets(10, 10, 0, 0);

        return constraints;
    }
}