package com.models;

import com.interfaces.DegreeScale;

public class Fahrenheit implements DegreeScale {
    private String cyrillicName;

    public Fahrenheit() {
        cyrillicName = "Фаренгейта";
    }

    @Override
    public double convertScale(double degrees, String toScale) {
        if (toScale.equals("Кельвина")) {
            return toKelvin(degrees);
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
        return (degrees - 32) * 5 / 9;
    }

    private double toKelvin(double degrees) {
        return (degrees - 32) * 5 / 9 + 273.15;
    }
}