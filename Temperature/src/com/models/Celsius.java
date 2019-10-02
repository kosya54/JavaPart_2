package com.models;

import com.interfaces.DegreeScale;

public class Celsius implements DegreeScale {
    private String cyrillicName = "Цельсия";
    private double degrees;

    public Celsius() {

    }

    public Celsius(double degrees) {
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

    private double toKelvin() {
        return degrees + 273.15;
    }

    private double toFahrenheit() {
        return (degrees * 9 / 5) + 32;
    }
}
