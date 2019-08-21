package com;

import com.MyLinkedList.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirstItem(1);
        list.addFirstItem(2);
        list.addFirstItem(3);
        list.addFirstItem(4);
        list.printList();

        System.out.println(list.removeItemByData(0));
        list.printList();

/*        MyLinkedList<Integer> list = new MyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);

        System.out.println("First item data: " + list.getFirstItemData());

        list.printList();
        System.out.println("Size: " + list.size());

        list.addByIndex(1, 11);
        list.printList();
        System.out.println("Size: " + list.size());

        System.out.println(list.getByIndex(3));
        System.out.println(list.replaceByIndex(1, 22));
        list.printList();

        System.out.println(list.removeFirst());
        list.printList();

        System.out.println("Удалено? " + list.removeByData(4));
        list.printList();

        System.out.println("Удаленный элемент: " + list.removeByIndex(2));
        list.printList();

        list.printList();
        list.printLinks();

        MyLinkedList<Integer> copyList = list.copy();

        copyList.printList();
        copyList.printLinks(); */
    }
}