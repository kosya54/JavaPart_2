package com.controllers;

import com.models.TemperatureModel;

public class ScalesController {
    private TemperatureModel temperatureModel;

    public ScalesController() {
        temperatureModel = new TemperatureModel();
    }

    public static boolean isNumber(String enteredDegrees) {
        boolean isDigit = false;
        for (int i = 0; i < enteredDegrees.length(); i++) {
            isDigit = Character.isDigit(enteredDegrees.charAt(i));
        }
        return isDigit;
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