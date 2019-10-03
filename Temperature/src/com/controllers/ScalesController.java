package com.controllers;

import com.interfaces.DegreeScale;

import com.models.Celsius;
import com.models.Fahrenheit;
import com.models.Kelvin;

import java.util.ArrayList;

public class ScalesController {
    private ArrayList<DegreeScale> scales = new ArrayList<>();

    public ScalesController() {
        scales.add(new Celsius());
        scales.add(new Kelvin());
        scales.add(new Fahrenheit());
    }

    public static boolean isNumber(String enteredDegrees) {
        boolean isDigit = false;
        for (int i = 0; i < enteredDegrees.length(); i++) {
            isDigit = Character.isDigit(enteredDegrees.charAt(i));
        }
        return isDigit;
    }

    public String[] getCyrillicNamesArray() {
        String[] names = new String[scales.size()];

        int i = 0;
        for (DegreeScale scale : scales) {
            names[i] = scale.getCyrillicName();
            ++i;
        }

        return names;
    }

    public double callModelMethod(double degrees, String fromScale, String toScale) {
        double convertedDegree = 0;
        for (DegreeScale scale : scales) {
            if (scale.getCyrillicName().equals(fromScale)) {
                convertedDegree = scale.convertScale(degrees, toScale);
                break;
            }
        }
        return convertedDegree;
    }
}