package com.shapes;

import com.interfaces.Shape;

public class Square implements Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return getWidth();
    }

    @Override
    public double getArea() {
        return Math.pow(width, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * width;
    }

    @Override
    public String toString() {
        return String.format("Фигура: %s.%n" +
                             "Ширина: %.2f.%n" +
                             "Площадь: %.2f.%n" +
                             "Периметр: %.2f.%n" +
                             "Хэш: %d.",
                             getClass().getSimpleName(), width, getArea(), getPerimeter(), hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Square square = (Square) object;

        return width == square.width;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        return hash;
    }
}