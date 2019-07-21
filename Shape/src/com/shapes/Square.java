package com.shapes;

import com.interfaces.Shape;

public class Square implements Shape {
    private double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.getWidth();
    }

    @Override
    public double getArea() {
        return Math.pow(this.width, 2);
    }

    @Override
    public double getPerimeter() {
        return 4 * this.width;
    }

    @Override
    public String toString() {
        return String.format("Ширина: %.2f.%nВысота: %.2f.%nПлощадь: %.2f.%nПериметр: %.2f.%nХэш: %d.", getWidth(), getHeight(), getArea(), getPerimeter(), hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) object;

        return getWidth() == square.getWidth() && getHeight() == square.getHeight() && getArea() == square.getArea() && getPerimeter() == square.getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        return hash;
    }
}