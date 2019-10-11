package com.models;

import com.interfaces.DegreeScale;

public class Celsius implements DegreeScale {
    private String name;

    public Celsius() {
        name = "Цельсия";
    }

    public String getName() {
        return name;
    }

    @Override
    public double toCelsius(double degrees) {
        return degrees;
    }

    @Override
    public double fromCelsius(double degrees) {
        return degrees;
    }
}
