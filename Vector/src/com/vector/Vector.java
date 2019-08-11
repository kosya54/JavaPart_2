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

    public void summarize(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public void multiply(double number) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= number;
        }
    }

    public void inverse() {
        final double INVERSE = -1;
        multiply(INVERSE);
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
            throw new IllegalArgumentException("Не верное значение индекса.");
        }
        return components[index];
    }

    public void setComponentByIndex(int index, double value) {
        if (index > components.length || index < 0) {
            throw new IllegalArgumentException("Не верное значение индекса.");
        }
        components[index] = value;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.summarize(vector2);

        return newVector;
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.subtract(vector2);

        return newVector;
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