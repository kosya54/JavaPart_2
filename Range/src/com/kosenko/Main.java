package com.kosenko;

import com.kosenko.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало первого интервала: ");
        double from1;
        if (scanner.hasNextDouble()) {
            from1 = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        System.out.println("Введите конец первого интервала: ");
        double to1;
        if (scanner.hasNextDouble()) {
            to1 = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        Range range1 = new Range(from1, to1);

        System.out.println("Введите начало второго интервала: ");
        double from2;
        if (scanner.hasNextDouble()) {
            from2 = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        System.out.println("Введите конец второго интервала: ");
        double to2;
        if (scanner.hasNextDouble()) {
            to2 = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не верные данные.");
            return;
        }

        Range range2 = new Range(from2, to2);

        System.out.printf("Интревал 1: {%.1f : %.1f}, длина интервала = %.0f.%n", range1.getFrom(), range1.getTo(), range1.getLength());
        System.out.printf("Интервал 2: {%.1f : %.1f}, длина интервала = %.0f.%n", range2.getFrom(), range2.getTo(), range2.getLength());

        if (range1.getIntersection(range2) == null) {
            System.out.println("null");
        } else {
            System.out.printf("Интервал пересечения: {%.1f : %.1f}%n", range1.getIntersection(range2).getFrom(), range1.getIntersection(range2).getTo());
        }

        if (range1.getUnion(range2).length == 1) {
            System.out.printf("Интервал объединения: {%.1f : %.1f}%n", range1.getUnion(range2)[0].getFrom(), range1.getUnion(range2)[0].getTo());
        } else {
            System.out.printf("Интервалы объединения: {%.1f : %.1f}, {%.1f : %.1f}%n", range1.getUnion(range2)[0].getFrom(), range1.getUnion(range2)[0].getTo(), range1.getUnion(range2)[1].getFrom(), range1.getUnion(range2)[1].getTo());
        }

        if (range1.getDifference(range2).length != 0) {
            System.out.printf("Разность интервалов: {%.1f : %.1f}%n", range1.getDifference(range2)[0].getFrom(), range1.getDifference(range2)[0].getTo());
        } else if (range1.getDifference(range2).length > 1) {
            System.out.printf("Разность интервалов: {%.1f : %.1f}, {%.1f : %.1f}%n", range1.getDifference(range2)[0].getFrom(), range1.getDifference(range2)[0].getTo(), range1.getDifference(range2)[1].getFrom(), range1.getDifference(range2)[1].getTo());
        } else {
            System.out.println("Разность интервало: 0");
        }
    }
}