package com.controllers;

import com.models.TemperatureModel;

public class ScalesController {
    private TemperatureModel temperatureModel;

    public ScalesController() {
        temperatureModel = new TemperatureModel();
    }

    public static boolean isNumber(String enteredDegrees) {
        int noDigitCount = 0;
        for (int i = 0; i < enteredDegrees.length(); i++) {
            if (!Character.isDigit(enteredDegrees.charAt(i))) {
                ++noDigitCount;
            }
        }
        return noDigitCount <= 0;
    }

    public String[] getCyrillicNames() {
        String[] cyrillicNames = new String[temperatureModel.getCyrillicNames().size()];

        return temperatureModel.getCyrillicNames().toArray(cyrillicNames);
    }

    public double callModelMethod(double degrees, String from, String to) {
        if (from.equals(to)) {
            return degrees;
        }
        return temperatureModel.convertScales(degrees, from + " " + to);
    }
}