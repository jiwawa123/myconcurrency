package com.ji.concurrency.chapter11;/*
    user ji
    data 2019/3/12
    time 8:00 PM
*/

import java.util.stream.IntStream;

public class ContextTest {
    public static void main(String[] args) {

        IntStream.range(0, 10).forEach(i -> new Thread(new ExecutionTask()).start());
    }
}
