package com.vector;

import java.util.Arrays;

public class Vector {
    private int vectorSize;
    private double[] vectorArray;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n не должно быть <= 0!");
        }

        vectorSize = n;
        vectorArray = new double[vectorSize];

        for (int i = 0; i < vectorSize; i++) {
            vectorArray[i] = 0;
        }
    }

    public Vector(Vector otherVector) {
        vectorSize = otherVector.vectorSize;
        vectorArray = Arrays.copyOf(otherVector.vectorArray, otherVector.vectorArray.length);
    }

/*    Vector (double[] vector) {

    }

    Vector(int n, double[] vector) {

    } */

    public int getSize() {
        return vectorSize;
    }

    public double[] getVectorArray() {
        return vectorArray;
    }

    public void setSize(int n) {
        vectorSize = n;
    }

    public void printVector() {
        System.out.println(Arrays.toString(vectorArray));
    }
}