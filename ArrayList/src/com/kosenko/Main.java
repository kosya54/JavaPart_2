package com.kosenko;

import com.kosenko.util.MyArrayList;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();

        for (int i = 1; i <= 12; i++) {
            myArrayList1.add(i);
        }

        ArrayList<Integer> test = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            test.add(3);
        }

        myArrayList1.add(0, null);
        myArrayList1.add(3, null);
        myArrayList1.add(8, null);
        myArrayList1.add(9, null);
        myArrayList1.add(4, 99);
        myArrayList1.add(7, 99);
        myArrayList1.add(11, 99);

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(99);
        temp.add(null);
        System.out.println(temp);
        System.out.println(myArrayList1.size());
        System.out.println(myArrayList1.tempToString());
        System.out.println(myArrayList1.addAll(5, temp));
        System.out.println(myArrayList1.tempToString());

//        System.out.println(myArrayList1.containsAll(test));
    }
}
