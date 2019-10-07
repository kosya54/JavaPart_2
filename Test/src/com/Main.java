package com;

import com.Test.*;

public class Main {
    public static void main(String[] args) {
        String scale1 = "Цельсия";
        String scale2 = "Кельвин";
        String scale3 = "Фаренгейта";

        CollectionTest test = new CollectionTest();

        test.convertTemperature(scale3);
        System.out.println();

/*        test.convertTemperature(scale2);
        System.out.println();

        test.convertTemperature(scale3);
        System.out.println(); */
    }
}
