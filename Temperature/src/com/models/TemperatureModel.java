package com.models;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.function.*;

public class TemperatureModel {
    private Map<String, UnaryOperator<Double>> scales = new HashMap<>();
    private ArrayList<String> cyrillicNames = new ArrayList<>();

    public TemperatureModel() {
        UnaryOperator<Double> celsiusToKelvin = x -> x + 273.15;
        scales.put("Цельсия Кельвин", celsiusToKelvin);

        UnaryOperator<Double> celsiusToFahrenheit = x -> (x * 9 / 5) + 32;
        scales.put("Цельсия Фаренгейта", celsiusToFahrenheit);

        UnaryOperator<Double> fahrenheitToCelsius = x -> (x - 32) * 5 / 9;
        scales.put("Фаренгейта Цельсия", fahrenheitToCelsius);

        UnaryOperator<Double> fahrenheitToKelvin = x -> (x - 32) * 5 / 9 + 273.15;
        scales.put("Фаренгейта Кельвин", fahrenheitToKelvin);

        UnaryOperator<Double> kelvinToCelsius = x -> x - 273.15;
        scales.put("Кельвин Цельсия", kelvinToCelsius);

        UnaryOperator<Double> kelvinToFahrenheit = x -> (x - 273.15) * 9 / 5 + 32;
        scales.put("Кельвин Фаренгейта", kelvinToFahrenheit);

        cyrillicNames.add("Цельсия");
        cyrillicNames.add("Кельвин");
        cyrillicNames.add("Фаренгейта");
    }

    public ArrayList<String> getCyrillicNames() {
        return cyrillicNames;
    }

    public double convertScales(double degrees, String fromTo) {
        if (!scales.containsKey(fromTo)) {
            throw new NullPointerException("Ключ не найден");
        }
        return scales.get(fromTo).apply(degrees);
    }
}
