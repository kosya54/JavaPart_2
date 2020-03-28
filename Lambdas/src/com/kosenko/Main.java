package com.kosenko;

import com.kosenko.persons.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Василий", 27));
        persons.add(new Person("Василий", 35));
        persons.add(new Person("Иван", 20));
        persons.add(new Person("Михаил", 15));
        persons.add(new Person("Михаил", 54));
        persons.add(new Person("Евгений", 33));
        persons.add(new Person("Алиса", 3));
        persons.add(new Person("Кортана", 7));
        persons.add(new Person("Сири", 9));

        System.out.println("Пункты задачи А и Б:");
        String uniqueNames = persons.stream().map(Person::getName).distinct()
                .collect(Collectors.joining(", ", "Имена: ", "."));
        System.out.println(uniqueNames);
        System.out.println();

        System.out.println("Пункт задачи В:");
        persons.stream().filter(age -> age.getAge() < 18).mapToDouble(Person::getAge)
                .average().ifPresent(System.out::println);
        System.out.println();

        System.out.println("Пункт задачи Г:");
        Map<String, Double> personsMap = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));
        personsMap.forEach((name, averageAge) -> System.out.println(name + ": " + averageAge));
        System.out.println();

        System.out.println("Пункт задачи Д:");
        persons.stream().filter(age -> age.getAge() >= 20 && age.getAge() <= 45)
                .sorted(Comparator.comparingInt(Person::getAge).reversed())
                .map(Person::getName).forEach(System.out::println);
    }
}
