package com.ji.concurrency.chapter14;/*
    user ji
    data 2019/3/13
    time 8:52 AM
*/

import java.util.Currency;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

public class JDKCountDown {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        System.out.println("准备多线程处理任务");
        //the first phase
        IntStream.range(0, 5).forEach(i -> new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+" is working ");
            try {
                Thread.sleep(random.nextInt(1000));
                latch.countDown();
            } catch (InterruptedException e) {

            }
        }, String.valueOf(i)).start());
        latch.await();
        System.out.println("多线程任务处理结束，开启第二阶段");
        //the second phase


    }
}
