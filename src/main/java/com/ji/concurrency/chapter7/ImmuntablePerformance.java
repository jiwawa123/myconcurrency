package com.ji.concurrency.chapter7;/*
    user ji
    data 2019/3/12
    time 9:11 AM
*/

import java.util.stream.IntStream;

public class ImmuntablePerformance {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        SynObj synObj = new SynObj();
        synObj.setName("ji");
        Thread t1 = new Thread() {
            @Override
            public void run() {
                {
                    for (long i = 0L; i < 1000000; i++) {
                        System.out.println(Thread.currentThread().getName() + "  " + synObj.toString());
                    }
                }
            }
        };
        t1.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                {
                    for (long i = 0L; i < 1000000; i++) {
                        System.out.println(Thread.currentThread().getName() + "  " + synObj.toString());
                    }
                }
            }
        };
        t2.start();
        t1.join();
        t2.join();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}

final class ImmutableObj {
    private final String name;

    @Override
    public String toString() {
        return "ImmutableObj{" +
                "name='" + name + '\'' +
                '}';
    }

    public ImmutableObj(String name) {
        this.name = name;
    }
}

class SynObj {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public synchronized String toString() {
        return "SynObj{" +
                "name='" + name + '\'' +
                '}';
    }

    public synchronized void setName(String name) {
        this.name = name;
    }
}
