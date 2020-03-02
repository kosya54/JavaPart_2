package com.kosenko;

import com.kosenko.util.MyArrayList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> test = new MyArrayList<>();

        for (int i = 1; i <= 20; i++) {
            test.add(i);
        }

        System.out.println(test);

        Iterator<Integer> myIterator = test.iterator();

        int count = 0;
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());

            if (count == 10) {
                test.add(777);
            }
            ++count;
        }
    }
}
