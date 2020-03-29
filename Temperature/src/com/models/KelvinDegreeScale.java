package com.models;

import com.kosenko.interfaces.DegreeScale;

public class KelvinDegreeScale implements DegreeScale {
    @Override
    public String getName() {
        return "Кельвин";
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
