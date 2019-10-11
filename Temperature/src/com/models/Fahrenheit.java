package com.models;

import com.interfaces.DegreeScale;

public class Fahrenheit implements DegreeScale {
    private String name;

    public Fahrenheit() {
        name = "Фаренгейта";
    }

    public String getName() {
        return name;
    }

    @Override
    public double toCelsius(double degrees) {
        return (degrees - 32) * 5 / 9;
    }

    @Override
    public double fromCelsius(double degrees) {
        return (degrees * 9 / 5) + 32;
    }
}
