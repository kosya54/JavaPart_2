package com.views;

import com.controllers.ScalesController;

import javax.swing.*;
import java.awt.*;

public class TemperatureView {
    private JFrame frame;

    private JTextField input;
    private JTextField result;

    private JComboBox<String> leftSelect;
    private JComboBox<String> rightSelect;

    private GridBagConstraints constraints;
    private ScalesController scalesController;

    private Font font;

    public TemperatureView() {
        frame = new JFrame("Перевод температур");
        font = new Font("Arial Narrow", Font.PLAIN, 18);

        constraints = setConstraints();
        scalesController = new ScalesController();

        int width = 400;
        int height = 200;

        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(createGUI());
    }

    public void showGUI() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.out.println("Error");
            }
            frame.setVisible(true);
        });
    }

    private JPanel createGUI() {
        JPanel panel = new JPanel(new GridBagLayout());

        input = new JTextField(10);
        input.setFont(font);
        input.setHorizontalAlignment(SwingConstants.CENTER);

        constraints.gridx = 0;
        constraints.gridy = 0;

        panel.add(input, constraints);

        JLabel equally = new JLabel("=");
        equally.setFont(font);
        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = 0;
        panel.add(equally, constraints);

        result = new JTextField(10);
        result.setFont(font);
        result.setEditable(false);
        result.setBackground(Color.WHITE);
        result.setHorizontalAlignment(SwingConstants.CENTER);

        constraints.gridx = GridBagConstraints.RELATIVE;
        constraints.gridy = 0;

        panel.add(result, constraints);

        leftSelect = new JComboBox<>(scalesController.getCyrillicNamesArray());
        leftSelect.setBackground(Color.WHITE);

        constraints.gridx = 0;
        constraints.gridy = 1;

        panel.add(leftSelect, constraints);

        rightSelect = new JComboBox<>(scalesController.getCyrillicNamesArray());
        rightSelect.setBackground(Color.WHITE);

        constraints.gridx = 2;
        constraints.gridy = 1;

        panel.add(rightSelect, constraints);

        JButton convertButton = new JButton("Перевести");
        convertButton.setBackground(Color.WHITE);

        constraints.gridx = 2;
        constraints.gridy = 2;

        panel.add(convertButton, constraints);

        convertButton.addActionListener(e -> {
            if (ScalesController.isNumber(input.getText()) && leftSelect.getSelectedItem() != null && rightSelect.getSelectedItem() != null) {
                double enteredDegrees = Double.parseDouble(input.getText());

                String fromScale = (String) leftSelect.getSelectedItem();
                String toScale = (String) rightSelect.getSelectedItem();

                String convertedDegrees = Double.toString(scalesController.callModelMethod(enteredDegrees, fromScale, toScale));

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