package com.ji.concurrency3.utils;
/*
    user ji
    data 2019/3/24
    time 3:26 PM
*/

import java.util.concurrent.CountDownLatch;

public class CountDownExample3 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        latch.await();
        latch.countDown();
        System.out.println("=========");
    }
}
