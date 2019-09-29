package com.controllers;

import com.models.TemperatureModel;

public class TemperatureController {
    public static boolean isNumber(String enteredDegrees) {
        boolean isDigit = false;
        for (int i = 0; i < enteredDegrees.length(); i++) {
            isDigit = Character.isDigit(enteredDegrees.charAt(i));
        }
        return isDigit;
    }

    public static String callModelMethod(double enteredDegrees, String leftDegreeScale, String rightDegreeScale) {
        TemperatureModel model = new TemperatureModel(enteredDegrees);

        if (leftDegreeScale.equals("Цельсия") && rightDegreeScale.equals("Кельвина")) {
            return Double.toString(model.celsiusToKelvin());
        }

        if (leftDegreeScale.equals("Цельсия") && rightDegreeScale.equals("Фаренгейта")) {
            return Double.toString(model.celsiusToFahrenheit());
        }

        if (leftDegreeScale.equals("Кельвина") && rightDegreeScale.equals("Цельсия")) {
            return Double.toString(model.kelvinToCelsius());
        }

        if (leftDegreeScale.equals("Кельвина") && rightDegreeScale.equals("Фаренгейта")) {
            return Double.toString(model.kelvinToFahrenheit());
        }

        if (leftDegreeScale.equals("Фаренгейта") && rightDegreeScale.equals("Цельсия")) {
            return Double.toString(model.fahrenheitToCelsius());
        }

        if (leftDegreeScale.equals("Фаренгейта") && rightDegreeScale.equals("Кельвина")) {
            return Double.toString(model.fahrenheitToKelvin());
        }

        return Double.toString(enteredDegrees);
    }
}