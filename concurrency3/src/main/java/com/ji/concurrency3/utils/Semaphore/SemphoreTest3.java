package com.ji.concurrency3.utils.Semaphore;/*
    user ji
    data 2019/3/25
    time 11:01 AM
*/

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreTest3 {
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                try{
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
                System.out.println("T1 finished");
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try{
                    semaphore.acquire();
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
                System.out.println("T2 finished");

            }
        };
        t2.start();

        TimeUnit.MICROSECONDS.sleep(1);
        t2.interrupt();
    }
}
