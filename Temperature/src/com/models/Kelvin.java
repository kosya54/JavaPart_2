package com.models;

import com.interfaces.DegreeScale;

public class Kelvin implements DegreeScale {
    private String cyrillicName;

    public Kelvin() {
        cyrillicName = "Кельвина";
    }

    @Override
    public double convertScale(double degrees, String toScale) {
        if (toScale.equals("Фаренгейта")) {
            return toFahrenheit(degrees);
        }

        if (toScale.equals("Цельсия")) {
            return toCelsius(degrees);
        }
        return degrees;
    }

    @Override
    public String getCyrillicName() {
        return cyrillicName;
    }

    private double toCelsius(double degrees) {
        return degrees - 273.15;
    }

    private double toFahrenheit(double degrees) {
        return (degrees - 273.15) * 9 / 5 + 32;
    }
}