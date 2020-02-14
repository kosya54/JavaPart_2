package com.kosenko;

import com.kosenko.util.MyArrayList;
import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
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
        for (int i = 1; i <= 5; i++) {
            test.add(i);
        }

        System.out.printf("Collection: %s, size: %s%n", myArrayList1.tempToString(), myArrayList1.size());
        System.out.printf("Collection for retain: %s%n", test);
        myArrayList1.retainAll(test);
        System.out.printf("Collection after retainAll: %s", myArrayList1.tempToString());
    }
}
