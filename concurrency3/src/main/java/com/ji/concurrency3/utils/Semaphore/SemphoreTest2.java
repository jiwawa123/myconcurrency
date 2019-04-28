package com.ji.concurrency3.utils.Semaphore;/*
    user ji
    data 2019/3/25
    time 10:40 AM
*/

import sun.awt.windows.ThemeReader;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreTest2 {
    /*
     available connection
     */
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 2; i++) {
            new Thread() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " in");
                    try {
                        semaphore.acquire(1);
                        System.out.println(Thread.currentThread().getName() + "i am working");
                        TimeUnit.SECONDS.sleep(5);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release(1);
                    }
                    System.out.println(Thread.currentThread().getName() + " out");

                }

            }.start();
        }
        while(true){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(semaphore.availablePermits());
                System.out.println(semaphore.getQueueLength());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
