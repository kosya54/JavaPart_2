package com.models;

import com.interfaces.DegreeScale;

public class CelsiusDegreeScale implements DegreeScale {
    @Override
    public String getName() {
        return "Цельсия";
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
