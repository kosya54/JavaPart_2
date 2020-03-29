package com.interfaces;

public interface DegreeScale {
    String getName();

    double toCelsius(double degrees);

    double fromCelsius(double degrees);
}
