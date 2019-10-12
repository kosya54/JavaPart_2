package com.models;

import com.interfaces.DegreeScale;

public class Kelvin implements DegreeScale {
    private String name;

    public Kelvin() {
        name = "Кельвин";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double toCelsius(double degrees) {
        return degrees - 273.15;
    }

    @Override
    public double fromCelsius(double degrees) {
        return degrees + 273.15;
    }
}
