package com;

import com.vector.Vector;

class Main {
    public static void main(String[] args) {
        System.out.println("-========Не статические методы========-");
        System.out.println();

        Vector vector1 = new Vector(7);
        System.out.println("Вектор1: " + vector1.toString());

        double[] array = new double[]{1, 2, 5, 7, 9, 11, 15};

        Vector vector2 = new Vector(array);
        System.out.println("Вектор2: " + vector2.toString());

        Vector vector3 = new Vector(vector2);
        System.out.println("Вектор3: " + vector3.toString());


        Vector vector4 = new Vector(20, array);
        System.out.println("Вектор4: " + vector4.toString());
        System.out.println();

        System.out.printf("Вектор1 == Вектор2 ? %b%nХэш Вектор1: %d%nХэш Вектор2: %d%n%n", vector1.equals(vector2), vector1.hashCode(), vector2.hashCode());
        System.out.printf("Вектор2 == Вектор3 ? %b%nХэш Вектор2: %d%nХэш Вектор3: %d%n%n", vector2.equals(vector3), vector2.hashCode(), vector3.hashCode());
        System.out.println();

        vector1.sum(vector2);
        System.out.printf("Вектор1 + Вектор2 = %s%n", vector1.toString());

        vector4.subtract(vector3);
        System.out.printf("Вектор4 - Вектор3 = %s%n", vector4.toString());

        vector2.multiply(22);
        System.out.printf("Вектор2 * 22 = %s%n", vector2.toString());

        vector3.inverse();
        System.out.printf("Вектор3 * -1 = %s%n", vector3.toString());
        System.out.println();

        System.out.printf("Длина Вектор1: %f, размер: %d%n", vector1.getLength(), vector1.getSize());
        System.out.printf("Длина Вектор2: %f, размер: %d%n", vector2.getLength(), vector2.getSize());
        System.out.printf("Длина Вектор3: %f, размер: %d%n", vector3.getLength(), vector3.getSize());
        System.out.printf("Длина Вектор4: %f, размер: %d%n", vector4.getLength(), vector4.getSize());
        System.out.println();

        System.out.printf("Компонента Вектор3 по индексу 5 равна: %f%n", vector3.getComponentByIndex(5));
        System.out.println("Меняем компоненту Вектор3 по индексу 5 на 22.");

        vector3.setComponentByIndex(5, 22);
        System.out.printf("Компонента Вектор3 по индексу 5 равна: %f%n", vector3.getComponentByIndex(5));
        System.out.println();

        System.out.println("-========Статические методы========-");
        System.out.println();

        Vector vector5 = Vector.getSum(vector1, vector2);
        System.out.println("Вектор1: " + vector1.toString() + " + " + "Вектор2: " + vector2.toString() + " = " + "Вектор5: " + vector5.toString());
        System.out.println();

        Vector vector6 = Vector.getSubtraction(vector5, vector3);
        System.out.println("Вектор5: " + vector5.toString() + " - " + "Вектор3: " + vector3.toString() + " = " + "Вектор6: " + vector6.toString());
        System.out.println();

        Vector vector7 = new Vector(array);
        System.out.printf("Вектор2 * Вектор7 = %f", Vector.getMultiplication(vector2, vector7));
    }
}