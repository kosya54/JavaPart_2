package com.models;

import com.kosenko.interfaces.DegreeScale;

public class FahrenheitDegreeScale implements DegreeScale {
    @Override
    public String getName() {
        return "Фаренгейта";
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
