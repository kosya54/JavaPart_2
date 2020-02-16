package com.kosenko;

import com.kosenko.comparators.*;
import com.kosenko.interfaces.Shape;
import com.kosenko.shapes.*;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        Shape rectangle1 = new Rectangle(20, 30);
        shapes.add(rectangle1);

        Shape rectangle2 = new Rectangle(20, 30);
        shapes.add(rectangle2);

        Shape circle1 = new Circle(15);
        shapes.add(circle1);

        Shape circle2 = new Circle(30);
        shapes.add(circle2);

        Shape square1 = new Square(10);
        shapes.add(square1);

        Shape square2 = new Square(50);
        shapes.add(square2);

        Shape triangle1 = new Triangle(3, 7, 1, 2, 7, 4);
        shapes.add(triangle1);

        Shape triangle2 = new Triangle(1, 3, 5, 7, 1, 10);
        shapes.add(triangle2);

        System.out.printf("Фигура с максимальной площадью.%n%s%n%n", getMaxAreaShape(shapes).toString());
        System.out.printf("Фигура с вторым по величине периметром.%n%s%n%n", getSecondMaxPerimeterShape(shapes).toString());

        System.out.printf("rectangle1 == rectangle2 ? %b%n", rectangle1.equals(rectangle2));
        System.out.printf("circle1 == circle2 ? %b%n", circle1.equals(circle2));
        System.out.printf("square1 == square2 ? %b%n", square1.equals(square2));
        System.out.printf("triangle1 == triangle2 ? %b", triangle1.equals(triangle2));
    }

    private static Shape getMaxAreaShape(ArrayList<Shape> shapes) {
        AreaComparator areaComparator = new AreaComparator();
        shapes.sort(areaComparator);

        return shapes.get(shapes.size() - 1);
    }

    private static Shape getSecondMaxPerimeterShape(ArrayList<Shape> shapes) {
        PerimeterComparator perimeterComparator = new PerimeterComparator();
        shapes.sort(perimeterComparator);

        return shapes.get(shapes.size() - 2);
    }
}