package com.ji.concurrency.chapter10;/*
    user ji
    data 2019/3/12
    time 2:32 PM
*/

import java.util.Random;

public class ThreadLocalComplexTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal();
    private static Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            threadLocal.set("ji");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
            } catch (InterruptedException e) {

            }
        });
        Thread t2 = new Thread(()->{
            threadLocal.set("wawa");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName()+" "+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(threadLocal.get());
    }
}
