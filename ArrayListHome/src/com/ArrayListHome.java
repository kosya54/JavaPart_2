package com;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

class ArrayListHome {
    public static void main(String[] args) throws IOException {
        System.out.println("№1. Прочитать в список из файла.");

        ArrayList<String> strings = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileInputStream("input.txt"))) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        }
        System.out.println(strings);
        System.out.println();

        System.out.println("№2. Удаление четных чисел из списка.");

        ArrayList<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(numbers1);

        numbers1.removeIf(number -> (number % 2 == 0));

        System.out.println(numbers1);
        System.out.println();

        System.out.println("№3. Новый список уникальных чисел из существующего списка.");

        ArrayList<Integer> numbers2 = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5, 1, 3, 55, 1, 1, 1));
        System.out.println(numbers2);

        ArrayList<Integer> numbers3 = new ArrayList<>();

        for (int value : numbers2) {
            if (!numbers3.contains(value)) {
                numbers3.add(value);
            }
        }
        System.out.println(numbers3);
    }
}