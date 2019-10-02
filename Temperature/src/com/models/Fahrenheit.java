package com.models;

import com.interfaces.DegreeScale;

public class Fahrenheit implements DegreeScale {
    private String cyrillicName = "Фаренгейта";
    private double degrees;

    public Fahrenheit() {

    }

    public Fahrenheit(double degrees) {
        this.degrees = degrees;
    }

    @Override
    public double convertScale() {
        return 0;
    }

    @Override
    public String getCyrillicName() {
        return cyrillicName;
    }

    public double fahrenheitToCelsius() {
        return (degrees - 32) * 5 / 9;
    }

    public double fahrenheitToKelvin() {
        return (degrees - 32) * 5 / 9 + 273.15;
    }
}
