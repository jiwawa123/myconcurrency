package com.ji.concurrency.chapter14;/*
    user ji
    data 2019/3/13
    time 9:05 AM
*/

import java.util.Random;
import java.util.stream.IntStream;

public class MyCountDownClient {
    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        MyCountDown myCountDown = new MyCountDown(5);
        IntStream.range(0, 5).forEach(i -> new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " is doing");
            try {
                Thread.sleep(random.nextInt(1000));
                myCountDown.down();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, String.valueOf(i)).start());
        myCountDown.await();
        System.out.println("the second phase starts ");
        System.out.println("======================= ");
        System.out.println("finished");

    }
}
