package com.kosenko.shapes;

import com.kosenko.interfaces.Shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return getWidth();
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return String.format("Фигура: %s.%n" +
                        "Радиус: %.2f.%n" +
                        "Площадь: %.2f.%n" +
                        "Периметр: %.2f.%n" +
                        "Хэш: %d.",
                getClass().getSimpleName(),
                radius,
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

        Circle circle = (Circle) object;

        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;

        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }
}