package com.kosenko;

import com.kosenko.my.Pair;
import com.kosenko.util.Util;

public class Main {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "Вася");
        Pair<Integer, String> pair2 = new Pair<>(2, "Петя");
        Pair<Integer, String> pair3 = new Pair<>(2, "Петя");
        Pair<Integer, String> pair4 = new Pair<>(4, "Лена");

        System.out.println(Util.compare(pair1, pair2));
        System.out.println(Util.compare(pair2, pair3));
    }
}
