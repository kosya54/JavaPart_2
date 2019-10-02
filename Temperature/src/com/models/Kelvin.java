package com.models;

import com.interfaces.DegreeScale;

public class Kelvin implements DegreeScale {
    private String cyrillicName = "Кельвин";
    private double degrees;

    public Kelvin() {

    }

    public Kelvin(double degrees) {
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

    public double kelvinToCelsius() {
        return degrees - 273.15;
    }

    public double kelvinToFahrenheit() {
        return (degrees - 273.15) * 9 / 5 + 32;
    }
}
