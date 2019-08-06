package com.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n не должно быть <= 0!");
        }

        components = new double[n];
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Вектор не может быть нулевой длины!");
        }
        components = Arrays.copyOf(array, array.length);
    }

    public Vector(int n, double[] array) {
        if (n <= 0) {
            throw new IllegalArgumentException("n не должно быть <= 0!");
        }

        if (array.length == 0) {
            throw new IllegalArgumentException("Вектор не может быть нулевой длины!");
        }

        components = Arrays.copyOf(array, n);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{ ");
        for (int i = 0; i < components.length; i++) {
            if (i == components.length - 1) {
                stringBuilder.append(components[i]);
            } else {
                stringBuilder.append(components[i]).append(", ");
            }
        }
        stringBuilder.append(" }");

        return stringBuilder.toString();
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

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public void sum(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        int minLength = Math.min(components.length, vector.components.length);

        for (int i = 0; i < minLength; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtraction(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        int minLength = Math.min(components.length, vector.components.length);

        for (int i = 0; i < minLength; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiplication(double number) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= number;
        }
    }

    public void inverse() {
        final double INVERSE = -1;
        multiplication(INVERSE);
    }

    public double getLength() {
        double sum = 0;
        for (double value : components) {
            sum += Math.pow(value, 2);
        }
        return Math.sqrt(sum);
    }

    public int getSize() {
        return components.length;
    }

    public double getComponentByIndex(int index) {
        if (index > components.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Не верное значение индекса.");
        }
        return components[index];
    }

    public void setComponentByIndex(int index, double value) {
        if (index > components.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Не верное значение индекса.");
        }
        components[index] = value;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector3 = new Vector(vector1);
        vector3.sum(vector2);

        return vector3;
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector vector3 = new Vector(vector1);
        vector3.subtraction(vector2);

        return vector3;
    }

    public static double getMultiplication(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.components.length, vector2.components.length);

        double multiplicationResult = 0;
        for (int i = 0; i < minLength; i++) {
            multiplicationResult += vector1.components[i] * vector2.components[i];
        }
        return multiplicationResult;
    }
}