package com.ji.concurrency;/*
    user ji
    data 2019/3/31
    time 8:20 PM
*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> l = new ArrayList<Integer>();
        IntStream.range(0,100000).forEach(i->l.add(i));
        System.out.println(l.size());
        System.out.println(System.currentTimeMillis() - start);
        start = System.currentTimeMillis();
        List<Integer> ll = new ArrayList<Integer>();
        for (int i = 0; i < 100000; i++) {
            ll.add(i);
        }
        System.out.println(ll.size());
        System.out.println(System.currentTimeMillis() - start);
//        long start = System.currentTimeMillis();
//        Stream s1 = l.stream().filter(i -> i % 2 == 0 && i % 5 != 0);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        Stream s2 = l.parallelStream().filter(i -> i % 2 == 0 && i % 5 != 0);
//        System.out.println(System.currentTimeMillis() - end);
    }
}
