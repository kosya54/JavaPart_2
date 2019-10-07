package com.models;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

public class TemperatureModel {
    private ArrayList<String> degreeScale = new ArrayList<>();

    TemperatureModel() {
        degreeScale.add("Цельсия");
        degreeScale.add("Кельвин");
        degreeScale.add("Фаренгейта");
    }

    public double convertTemperature(double degrees, String from, String to) {
        Stream<String> result = degreeScale.stream().filter(from::equals);

        return 0;
    }

    private double celsiusToKelvin(double degrees) {
        return degrees + 273.15;
    }

    private double celsiusToFahrenheit(double degrees) {
        return (degrees * 9 / 5) + 32;
    }

    private double kelvinToCelsius(double degrees) {
        return degrees - 273.15;
    }

    private double kelvinToFahrenheit(double degrees) {
        return (degrees - 273.15) * 9 / 5 + 32;
    }

    private double fahrenheitToCelsius(double degrees) {
        return (degrees - 32) * 5 / 9;
    }

    private double fahrenheitToKelvin(double degrees) {
        return (degrees - 32) * 5 / 9 + 273.15;
    }
}
