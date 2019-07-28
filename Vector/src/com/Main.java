package com;

import com.vector.Vector;

class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(7);
        System.out.println("Vector1: " + vector1);
        System.out.println("Vector1Array: " + vector1.getVectorArray());
        vector1.printVector();

        Vector vector2 = new Vector(vector1);
        System.out.println("Vector2: " + vector2);
        System.out.println("Vector2Array: " + vector2.getVectorArray());
        vector2.printVector();
//        System.out.println("Вектор 1: " + vector1.getSize());
    }
}