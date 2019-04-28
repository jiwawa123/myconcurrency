package com.ji.concurrency.chapter3;/*
    user ji
    data 2019/3/11
    time 2:06 PM
*/

public class VolatileTest1 {
    private static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 50;

    public static void main(String[] args) {
        /*
        如果不实用volatile关键字，那么就很难实现同步更新
         */
        new Thread(() -> {
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.println(Thread.currentThread().getName() + " update init_value " + (++INIT_VALUE));

            }
        }, "read").start();
        new Thread(() -> {
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.println(Thread.currentThread().getName() + " update init_value " + (++INIT_VALUE));

            }
        }, "read2").start();

    }
}
