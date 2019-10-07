package com.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionTest {
    private ArrayList<String> list = new ArrayList<>();

    public CollectionTest() {
        list.add("Цельсия");
        list.add("Кельвин");
        list.add("Фаренгейта");
    }

    public void convertTemperature(String from) {
        Stream<String> stream = list.stream();

        stream.filter(x -> x.equals(from)).forEach(System.out::println);
    }
}
