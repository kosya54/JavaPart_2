package com.kosenko.shapes;

import com.kosenko.interfaces.Shape;

public class Triangle implements Shape {
    private double x1;
    private double y1;

    private double x2;
    private double y2;

    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;

        this.x2 = x2;
        this.y2 = y2;

        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double getWidth() {
        return getSegmentLength(x1, x2, x3);
    }

    @Override
    public double getHeight() {
        return getSegmentLength(y1, y2, y3);
    }

    @Override
    public double getArea() {
        return ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1)) / 2;
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)) +
                Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2)) +
                Math.sqrt(Math.pow(x3 - x2, 2) + Math.pow(y3 - y2, 2));
    }

    @Override
    public String toString() {
        return String.format("Фигура: %s.%n" +
                        "Координаты вершин: A(%.2f, %.2f), B(%.2f, %.2f), C(%.2f, %.2f).%n" +
                        "Площадь: %.2f.%n" +
                        "Периметр: %.2f.%n" +
                        "Хэш: %d.",
                getClass().getSimpleName(),
                x1,
                y1,
                x2,
                y2,
                x3,
                y3,
                getArea(),
                getPerimeter(),
                hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) object;

        return x1 == triangle.x1 && x2 == triangle.x2 &&
                x3 == triangle.x3 && y1 == triangle.y1 &&
                y2 == triangle.y2 && y3 == triangle.y3;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;

        hash = prime * hash + Double.hashCode(x1);
        hash = prime * hash + Double.hashCode(y1);
        hash = prime * hash + Double.hashCode(x2);
        hash = prime * hash + Double.hashCode(y2);
        hash = prime * hash + Double.hashCode(x3);
        hash = prime * hash + Double.hashCode(y3);

        return hash;
    }

    private static double getSegmentLength(double coordinate1, double coordinate2, double coordinate3) {
        return getMax(coordinate1, coordinate2, coordinate3) - getMin(coordinate1, coordinate2, coordinate3);
    }

    private static double getMax(double coordinate1, double coordinate2, double coordinate3) {
        double max = Math.max(coordinate1, coordinate2);

        return Math.max(max, coordinate3);
    }

    private static double getMin(double coordinate1, double coordinate2, double coordinate3) {
        double min = Math.min(coordinate1, coordinate2);

        return Math.min(min, coordinate3);
    }
}