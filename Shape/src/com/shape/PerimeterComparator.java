package com.shape;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {

    public int compare(Shape shape1, Shape shape2) {
        final double EPSILON = 1.0e-10;
        if (Math.abs(shape1.getPerimeter() - shape2.getPerimeter()) <= EPSILON) {
            return 0;
        }

        if (shape1.getPerimeter() - shape2.getPerimeter() > EPSILON) {
            return 1;
        }
        return -1;
    }
}