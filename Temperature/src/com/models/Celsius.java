package com.models;

import com.interfaces.DegreeScale;

public class Celsius implements DegreeScale {
    private String cyrillicName;

    public Celsius() {
        cyrillicName = "Цельсия";
    }

    @Override
    public double convertScale(double degrees, String toScale) {
        if (toScale.equals("Кельвина")) {
            return toKelvin(degrees);
        }

        if (toScale.equals("Фаренгейта")) {
            return toFahrenheit(degrees);
        }
        return degrees;
    }

    @Override
    public String getCyrillicName() {
        return cyrillicName;
    }

    private double toKelvin(double degrees) {
        return degrees + 273.15;
    }

    private double toFahrenheit(double degrees) {
        return (degrees * 9 / 5) + 32;
    }
}