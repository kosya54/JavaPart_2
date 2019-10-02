package com.controllers;

import com.interfaces.DegreeScale;
import com.models.Celsius;
import com.models.Fahrenheit;
import com.models.Kelvin;

public class ScalesController {
    private DegreeScale celsius;
    private DegreeScale kelvin;
    private DegreeScale fahrenheit;

    public ScalesController() {
        celsius = new Celsius();
        kelvin = new Kelvin();
        fahrenheit = new Fahrenheit();
    }

    public static boolean isNumber(String enteredDegrees) {
        boolean isDigit = false;
        for (int i = 0; i < enteredDegrees.length(); i++) {
            isDigit = Character.isDigit(enteredDegrees.charAt(i));
        }
        return isDigit;
    }

    public String[] getCyrillicName() {
        return new String[] {celsius.getCyrillicName(), kelvin.getCyrillicName(), fahrenheit.getCyrillicName()};
    }

}
