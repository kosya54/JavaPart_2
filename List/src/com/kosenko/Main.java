package com.kosenko;

import com.kosenko.MyLinkedList.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();

        for (int i = 1; i < 10; i++) {
            list1.addFirstItem(i);
        }
        System.out.println("List1: " + list1);

        list1.addByIndex(9, 777);
        System.out.println("List1 добавляем 777 по индексу 9:" + list1);
        System.out.println();

        System.out.println("Значение первого элемента: " + list1.getFirstData());
        System.out.println();

        System.out.println("Значение по индексу 8: " + list1.getDataByIndex(8));
        System.out.println();

        System.out.println("Заменяем значение по индексу 3 на 999. " +
                "Удаленное значение: " + list1.replaceDataByIndex(3, 999));
        System.out.println(list1);
        System.out.println();

        System.out.println("Удаляем элемент по индексу 5. Удаленное значение: " + list1.removeByIndex(5));
        System.out.println(list1);
        System.out.println();

        System.out.println("Удаляем элемент по значению равному 999: " + list1.removeByData(999));
        System.out.println(list1);
        System.out.println();

        list1.removeFirst();
        System.out.println("Удаляем первый элемент: " + list1);
        System.out.println();

        list1.reverse();
        System.out.println("Разворчиваем список: " + list1);
        System.out.println();

        System.out.println("Размер списка: " + list1.size());
        System.out.println();

        System.out.println("Копируем List1 в List2 и удаляем у List2 по индексу 3.");
        MyLinkedList<Integer> list2 = list1.copy();

        list2.removeByIndex(3);

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
    }
}