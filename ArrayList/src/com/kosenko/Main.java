package com.kosenko;

import com.kosenko.util.MyArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();

        System.out.println("Size: " + myArrayList1.size());
        for (int i = 1; i <= 10; i++) {
            myArrayList1.add(i);
            System.out.println("Size: " + myArrayList1.size());
            System.out.println(myArrayList1.toString());
            System.out.println(myArrayList1.tempToString());
        }

        for (int i = 0, j = 1; i < 10; i++, j++) {
            myArrayList1.add(i, j);
            System.out.println("Size: " + myArrayList1.size());
            System.out.println(myArrayList1.toString());
            System.out.println(myArrayList1.tempToString());
        }
    }
}
