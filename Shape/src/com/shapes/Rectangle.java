package com.shapes;

import com.interfaces.Shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Фигура: %s.%nШирина: %.2f.%nВысота: %.2f.%nПлощадь: %.2f.%nПериметр: %.2f.%nХэш: %d.", getClass().getSimpleName(), width, height, getArea(), getPerimeter(), hashCode());
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;

        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;

        hash = prime * hash + Double.hashCode(width);
        hash = prime * hash + Double.hashCode(height);
        return hash;
    }
}