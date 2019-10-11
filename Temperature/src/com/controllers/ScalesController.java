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
        int noDigitCount = 0;
        for (int i = 0; i < enteredDegrees.length(); i++) {
            if (!Character.isDigit(enteredDegrees.charAt(i))) {
                ++noDigitCount;
            }
        }
        return noDigitCount <= 0;
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

        Set<Map.Entry<String, DegreeScale>> scalesEntry = scales.entrySet();

        for (Map.Entry<String, DegreeScale> scale : scalesEntry) {
            if (from.equals(scale.getKey())) {
                degrees = scale.getValue().toCelsius(degrees);
            }
        }

        for (Map.Entry<String, DegreeScale> scale : scalesEntry) {
            if (to.equals(scale.getKey())) {
                degrees = scale.getValue().fromCelsius(degrees);
            }
        }
        return degrees;
    }
/* TODO: Сделать проверку на существование методов интерфейса в классах или проверку, что классы реализуют интерфейс */
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
                    Constructor constructor = cls.getConstructor();
                    DegreeScale scale = (DegreeScale) constructor.newInstance();
                    scales.put(scale.getName(), scale);
                } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String formatName(String name) {
        int fileExtensionFirstIndex = name.lastIndexOf(".");

        if (fileExtensionFirstIndex > 0) {
            name = name.substring(0, fileExtensionFirstIndex);
        }
        return name;
    }
}