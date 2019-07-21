package com.comparators;

import com.interfaces.Shape;
import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        final double EPSILON = 1.0e-10;
        if (Math.abs(shape1.getArea() - shape2.getArea()) <= EPSILON) {
            return 0;
        }

        if (shape1.getArea() - shape2.getArea() > EPSILON) {
            return 1;
        }
        return -1;
    }
}