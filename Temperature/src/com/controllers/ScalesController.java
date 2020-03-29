package com.controllers;

import com.interfaces.DegreeScale;

import java.io.File;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ScalesController {
    private Map<String, DegreeScale> scales = new HashMap<>();

    public ScalesController() {
        loadScales();
    }

    public static boolean isNumber(String enteredDegrees) {
        for (int i = 0; i < enteredDegrees.length(); i++) {
            if (!Character.isDigit(enteredDegrees.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String[] getScalesNames() {
        String[] scalesNames = new String[scales.size()];

        Set<String> keys = scales.keySet();
        int i = 0;
        for (String key : keys) {
            scalesNames[i] = key;
            ++i;
        }
        return scalesNames;
    }

    public double convertScales(double degrees, String from, String to) {
        if (from.equals(to)) {
            return degrees;
        }

        double temporaryDegrees = scales.get(from).toCelsius(degrees);

        return scales.get(to).fromCelsius(temporaryDegrees);
    }

    private void loadScales() {
        final String modelsPackage = "com.models.";

        Path path = Paths.get("");
        String currentPath = path.toAbsolutePath().toString();

        File folder = new File(currentPath + "\\Temperature\\src\\com\\models");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                String name = modelsPackage + formatName(listOfFile.getName());

                try {
                    Class<?> cls = Class.forName(name);
                    if (isImplementsDegreeScale(cls)) {
                        Constructor constructor = cls.getConstructor();

                        DegreeScale scale = (DegreeScale) constructor.newInstance();
                        scales.put(scale.getName(), scale);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isImplementsDegreeScale(Class cls) {
        final String interfaceName = "com.interfaces.DegreeScale";

        Class[] interfaces = cls.getInterfaces();
        for (Class interfaceValue : interfaces) {
            if (interfaceValue.getName().equals(interfaceName)) {
                return true;
            }
        }
        return false;
    }

    private String formatName(String name) {
        int fileExtensionFirstIndex = name.lastIndexOf(".");

        if (fileExtensionFirstIndex > 0) {
            name = name.substring(0, fileExtensionFirstIndex);
        }
        return name;
    }
}