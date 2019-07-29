//http://www.mathelp.spb.ru/book1/vector.htm

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
        vectorComponents = Arrays.copyOf(vector.vectorComponents, vector.vectorComponents.length);
    }

    public Vector(double[] array) {
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
}

