package com.vector;

import java.util.Arrays;

public class Vector {
    private int length;
    private double[] vectorComponents;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n не должно быть <= 0!");
        }

        length = n;
        vectorComponents = new double[length];

        for (int i = 0; i < length; i++) {
            vectorComponents[i] = 0;
        }
    }

    public Vector(Vector vector) {
        length = vector.length;
        vectorComponents = Arrays.copyOf(vector.vectorComponents, length);
    }

    public Vector(double[] array) {
        length = array.length;
        vectorComponents = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("n не должно быть <= 0!");
        }

        length = n;
        vectorComponents = Arrays.copyOf(array, length);
    }

    @Override
    public String toString() {
        return Arrays.toString(vectorComponents).replace("[", "{ ").replace("]", " }");
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) object;

        if (length != vector.length) {
            return false;
        }

        boolean isEqual = false;
        for (int i = 0; i < length; i++) {
            isEqual = vectorComponents[i] == vector.vectorComponents[i];
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        final int PRIME = 7;
        int hash = 1;

        hash = PRIME * hash + length;

        for (int i = 0; i < length; i++) {
            hash = PRIME * hash + Double.hashCode(vectorComponents[i]);
        }
        return hash;
    }

    public void getSum(Vector vector) {
        if (length < vector.length) {
            length = vector.length;
            vectorComponents = Arrays.copyOf(vectorComponents, length);
        }

        if (length > vector.length) {
            vector.vectorComponents = Arrays.copyOf(vector.vectorComponents, length);
        }

        for (int j = 0; j < length; j++) {
            vectorComponents[j] += vector.vectorComponents[j];
        }
    }

    public void getSubtraction(Vector vector) {
        if (length < vector.length) {
            length = vector.length;
            vectorComponents = Arrays.copyOf(vectorComponents, length);
        }

        if (length > vector.length) {
            vector.length = length;
            vector.vectorComponents = Arrays.copyOf(vector.vectorComponents, length);
        }

        for (int j = 0; j < length; j++) {
            vectorComponents[j] -= vector.vectorComponents[j];
        }
    }

    public void getMultiplication(double number) {
        for (int i = 0; i < length; i++) {
            vectorComponents[i] *= number;
        }
    }

    public void getInverse() {
        final double INVERSE = -1;
        getMultiplication(INVERSE);
    }

    public double getLength() {
        double sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Math.pow(vectorComponents[i], 2);
        }
        return Math.abs(Math.sqrt(sum));
    }

    public int getSize() {
        return length;
    }

    public double getComponentByIndex(int index) {
        try {
            return vectorComponents[index];
        } catch (ArrayIndexOutOfBoundsException error) {
            index = 0;
            System.out.printf("Индекс не может быть меньше 0! - %s, возвращаю компоненту с индексом %d.", error, index);
        }
        return vectorComponents[index];
    }

    public void setComponentByIndex(int index, double value) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше 0!");
        }

        if (index > length) {
            throw new ArrayIndexOutOfBoundsException("Индекс не может быть больше длины компоненты.");
        }
        vectorComponents[index] = value;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        int length = vector1.length;

        if (vector1.length < vector2.length) {
            length = vector2.length;
            vector1.vectorComponents = Arrays.copyOf(vector1.vectorComponents, vector2.length);
        }

        if (vector1.length > vector2.length) {
            vector2.vectorComponents = Arrays.copyOf(vector2.vectorComponents, vector1.length);
        }

        double[] vectorComponents = new double[length];
        for (int i = 0; i < length; i++) {
            vectorComponents[i] = vector1.vectorComponents[i] + vector2.vectorComponents[i];
        }
        return new Vector(length, vectorComponents);
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        int length = vector1.length;

        if (vector1.length < vector2.length) {
            length = vector2.length;
            vector1.vectorComponents = Arrays.copyOf(vector1.vectorComponents, vector2.length);
        }

        if (vector1.length > vector2.length) {
            vector2.vectorComponents = Arrays.copyOf(vector2.vectorComponents, vector1.length);
        }

        double[] vectorComponents = new double[length];
        for (int i = 0; i < length; i++) {
            vectorComponents[i] = vector1.vectorComponents[i] - vector2.vectorComponents[i];
        }
        return new Vector(length, vectorComponents);
    }

    public static double getMultiplication(Vector vector1, Vector vector2) {
        int length = vector1.length;

        if (vector1.length < vector2.length) {
            length = vector2.length;
            vector1.vectorComponents = Arrays.copyOf(vector1.vectorComponents, vector2.length);
        }

        if (vector1.length > vector2.length) {
            vector2.vectorComponents = Arrays.copyOf(vector2.vectorComponents, vector1.length);
        }

        double multiplicationResult = 0;
        for (int i = 0; i < length; i++) {
            multiplicationResult += vector1.vectorComponents[i] * vector2.vectorComponents[i];
        }
        return multiplicationResult;
    }
}