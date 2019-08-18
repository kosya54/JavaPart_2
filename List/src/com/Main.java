package com;

import com.list.*;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myList = new MyLinkedList<>();
        ListItem<Integer> elementLink = new ListItem(33);

        System.out.println(elementLink);
        System.out.println(myList);
    }
}
