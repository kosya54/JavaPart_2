package com.models;

public class TemperatureModel {
    private double degrees;

    public TemperatureModel(double degrees) {
        this.degrees = degrees;
    }

    public double celsiusToKelvin() {
        return degrees + 273.15;
    }

    public double celsiusToFahrenheit() {
        return (degrees * 9 / 5) + 32;
    }

    public double kelvinToCelsius() {
        return degrees - 273.15;
    }

    public double kelvinToFahrenheit() {
        return (degrees - 273.15) * 9 / 5 + 32;
    }

    public double fahrenheitToCelsius() {
        return (degrees - 32) * 5 / 9;
    }

    public double fahrenheitToKelvin() {
        return (degrees - 32) * 5 / 9 + 273.15;
    }
}