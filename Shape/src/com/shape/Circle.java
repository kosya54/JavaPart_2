package com.shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return 2 * radius;
    }

    public double getHeight() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
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

        Circle circle = (Circle) object;

        return getWidth() == circle.getWidth() && getHeight() == circle.getHeight() && getArea() == circle.getArea() && getPerimeter() == circle.getPerimeter();
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;

        hash = prime * hash + Double.hashCode(radius);
        return hash;
    }
}