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
        for (int i = 1; i <= 10; i++) {
            test.add(i);
        }

        Iterator<Integer> iter = test.iterator();

        Iterator<Integer> iter2 = myArrayList1.iterator();
        int i = 0;
        System.out.println(myArrayList1.tempToString());
        while (i < 15) {
            iter2.remove();
            ++i;
        }
        System.out.println(myArrayList1.tempToString());
    }
}
