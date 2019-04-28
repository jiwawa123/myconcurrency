package com.ji.concurrency;/*
    user ji
    data 2019/4/1
    time 9:18 AM
*/

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class LambdaTest {
    //只有一个函数的接口
    @FunctionalInterface
    public interface Lambda1 {
        int add(int x, int y);
    }

    @FunctionalInterface
    public interface Lambda2 {
        boolean isEmpty(Object o);
    }

    @Test
    public void test() {
        Lambda1 lambda1 = (int x, int y) -> x + y;
        System.out.println(lambda1.add(5, 6));

    }

    @Test
    public void read() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/ji/test.txt"))) {
            StringBuffer sb = new StringBuffer();
            String tmp = null;
            while ((tmp = br.readLine()) != null)
                sb.append(tmp + "\n");
            System.out.println(sb.toString());
        }
    }

    @Test
    public void dke() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList());
        pairs.stream().forEach(System.out::println);
    }

    @Test
    public void match() {
        List<String> tmp = Arrays.asList("hello", "word", "this");
        System.out.println(tmp.stream().anyMatch(s -> s.contains("ll")));
    }

    @Test
    public void sum() {
        List<Integer> ll = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 6, 7, 7, 7);
        int sum = ll.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        int arr[] = {1, 2, 3, 4, 5, 8};
        int arr_sum = Arrays.stream(arr).reduce(0, Integer::sum);
        System.out.println(arr_sum);
        Optional<Integer> max = ll.stream().reduce(Integer::max);
        System.out.println(max.get());
    }

    @Test
    public void group() {
        List<Person> list = Arrays.asList(new Person("xiaoming", 12),
                new Person("xiaohong", 15), new Person("xiaogang", 15),
                new Person("xiaoming", 14), new Person("xiaohong", 15));
        Map<String, Map<Integer, List<Person>>> tmp = list.stream().collect(groupingBy(Person::getName,
                groupingBy(Person::getAge)));
        for (String name : tmp.keySet()
                ) {
            System.out.println("name " + name + " ");
            Map<Integer, List<Person>> map = tmp.get(name);
            for (int k : map.keySet()
                    ) {
                System.out.println("age " + k + " ");
                map.get(k).stream().forEach(System.out::println);
            }
        }
        Map<Integer, Long> agesCount = list.stream().collect(groupingBy(Person::getAge, counting()));
        for (int k : agesCount.keySet()
                ) {
            System.out.println(k + " age " + agesCount.get(k));
        }
        //Comparator<Person>  comparator = Comparator.comparingInt(Person::getAge);
        Optional<Person> max = list.stream().collect(maxBy(comparingInt(Person::getAge)));
        double allAge = list.stream().collect(averagingInt(Person::getAge));
        System.out.println(max.get() + " " + allAge);
        IntSummaryStatistics menuStatistics = list.stream().collect(summarizingInt(Person::getAge));
        System.out.println(menuStatistics);
        String allName = list.stream().map(Person::getName).collect(joining("\t"));
        System.out.println(allName);
        System.out.println(list.stream().filter(person -> person.age >= 15).count());
    }

    public class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
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
