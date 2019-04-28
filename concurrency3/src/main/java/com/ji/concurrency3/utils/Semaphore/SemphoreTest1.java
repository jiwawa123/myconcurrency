package com.ji.concurrency3.utils.Semaphore;/*
    user ji
    data 2019/3/25
    time 10:10 AM
*/

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreTest1 {
    public static void main(String[] args) throws InterruptedException {
        final SemphoreLock semphoreLock = new SemphoreLock();
        new Thread() {
            @Override
            public void run() {
                try {
                    semphoreLock.lock();
                    System.out.println("i am working");
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println(Thread.currentThread().getName() + " is ok");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semphoreLock.unlock();
                }

            }
        }.start();
        TimeUnit.SECONDS.sleep(1);
        new Thread() {
            @Override
            public void run() {
                try {
                    semphoreLock.lock();
                    System.out.println("i am working");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " is ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semphoreLock.unlock();
                }
            }
        }.start();

    }

    static class SemphoreLock {
        private final Semaphore semaphore = new Semaphore(2);

        public void lock() throws InterruptedException {
            semaphore.acquire();
        }

        public void unlock() {
            semaphore.release();
        }
    }
}
