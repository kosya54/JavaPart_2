package com;

import com.vector.Vector;

class Main {
    public static void main(String[] args) {
        double[] array = new double[] {1, 2, 5, 7, 9, 11, 15};

        Vector vector1 = new Vector(7);
        System.out.println(vector1.toString());
        System.out.println();

        Vector vector2 = new Vector(vector1);
        System.out.println(vector2.toString());
        System.out.println();

        Vector vector3 = new Vector(array);
        System.out.println(vector3.toString());
        System.out.println();


        Vector vector4 = new Vector(5, array);
        System.out.println("Vector4: " + vector4.toString());

        Vector vector5 = new Vector(3, array);
        System.out.println("Vector5: " + vector5.toString());
        System.out.println();

        vector4.getSum(vector5);
        System.out.println("Vector4 + Vector 5 = " + vector4.toString());
        System.out.println();

        vector4.getSubtraction(vector5);
        System.out.println("Vector4 - Vector 5 = " + vector4.toString());
        System.out.println();

        vector4.getMultiplication(2);
        System.out.println("Vector4 * 2 = " + vector4.toString());
        System.out.println();

        vector4.getInverse();
        System.out.println("Vector4 * -1 = " + vector4.toString());
        System.out.println();

        System.out.println("Vector4 length: " + vector4.getLength());
        System.out.println();

        System.out.println("Vector4 size: " + vector4.getSize());
    }
}