package com.ji.concurrency3.utils;
/*
    user ji
    data 2019/3/24
    time 2:50 PM
*/

import java.util.Random;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample1 {
    private static Random random = new Random(System.currentTimeMillis());
    private static ExecutorService executor = Executors.newFixedThreadPool(2);
    //设置等待的线程的个数，每次使用一次countDown 就会使等待的线程的个数减去1，知道等待的总数变成0的时候就会重新执行
    // 这个等待线程
    private static final CountDownLatch latch = new CountDownLatch(10);
    public static void main(String[] args) throws InterruptedException {
        int[] data = query();
        for (int i = 0; i < 9; i++) {
            executor.execute(new SimpleRunnable(data,i,latch));
        }
        //latch.countDown();
        latch.await();
        System.out.println("all work done");
        executor.shutdown();

    }

    static class SimpleRunnable implements Runnable {
        private final int[] data;
        private final int index;
        private final CountDownLatch latch;

        public SimpleRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (data[index] % 2 == 0)
                data[index] *= 2;
            else
                data[index] *= 5;
            System.out.println(Thread.currentThread().getName()+" is done");
            latch.countDown();
        }
    }

    private static int[] query() {
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }
}
