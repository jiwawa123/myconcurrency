package com.ji.concurrency.chapter7;/*
    user ji
    data 2019/3/12
    time 8:47 AM
*/

import java.util.stream.IntStream;

public class PersonClient {
    public static void main(String[] args) {
        Person person = new Person("Ji", "Beijing");
        IntStream.range(0, 5).
                forEach(i -> new UsePersonThread(person) {
                }.start());

    }
}
