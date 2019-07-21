package com.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
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

        Rectangle rectangle = (Rectangle) object;

        return getWidth() == rectangle.getWidth() && getHeight() == rectangle.getHeight() && getArea() == rectangle.getArea() && getPerimeter() == rectangle.getPerimeter();
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