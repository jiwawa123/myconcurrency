package com.ji.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        List<Person> l = new ArrayList<>();
        l.add(new Person("xiaoming", 109));
        l.add(new Person("xiaoming1", 10));
        l.add(new Person("xiaoming43", 100));
        l.sort(comparing(Person::getAge).reversed());
        System.out.println(l);
        l.sort(comparing(Person::getName));
        System.out.println(l);
        //l.stream().forEach(a -> System.out.print(a.getName()));
        List<String> tmp = l.stream().filter(person -> (person.age > 50))
                .filter(person -> !person.name.equals("xiaoming"))
                .map(Person::getName).limit(1).collect(Collectors.toList());
        System.out.println("tmp " +tmp);
//


    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
