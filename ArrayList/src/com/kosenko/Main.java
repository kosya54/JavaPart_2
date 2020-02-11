package com.kosenko;

import com.kosenko.util.MyArrayList;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList1 = new MyArrayList<>();

        for (int i = 1; i <= 10; i++) {
            myArrayList1.add(i);
        }

        ArrayList<Integer> test = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            test.add(i);
        }

        System.out.println(test);

        test.add(null);
        test.add(null);
        test.add(null);
        test.add(1, null);
        test.add(2, null);
        test.add(3, null);
        System.out.println(test);
    }
}
