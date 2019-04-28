package com.ji.concurrency;/*
    user ji
    data 2019/3/31
    time 8:08 PM
*/

import java.util.concurrent.TimeUnit;

public class ThreadTest {
    private final static int MAX_DEFAULT = 10000;
    private volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int x = 0;
            while (x < MAX_DEFAULT) {
                x++;
                i += 5;
            }
        }).start();
        new Thread(() -> {
            int x = 0;
            while (x < MAX_DEFAULT) {
                x++;
                i += 3;
            }
        }).start();
        Thread.sleep(2);
        System.out.println(i);
    }
}
