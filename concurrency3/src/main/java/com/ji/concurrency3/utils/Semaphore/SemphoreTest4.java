package com.ji.concurrency3.utils.Semaphore;/*
    user ji
    data 2019/3/25
    time 11:08 AM
*/

import java.util.Collection;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemphoreTest4 {
    public static void main(String[] args) throws InterruptedException {
        MySemaphore semaphore = new MySemaphore(5);
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                try {
                    semaphore.drainPermits();
                    System.out.println(semaphore.availablePermits());
                    TimeUnit.SECONDS.sleep(40);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(5);
                }
            }
        };
        t1.start();
        Thread.sleep(10);
        Thread t2 = new Thread("t2") {
            @Override
            public void run() {
                try {
                    boolean success = semaphore.tryAcquire(2, TimeUnit.SECONDS);
                    System.out.println(success ? "ok" : "timeout");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(semaphore.hasQueuedThreads());
        Collection<Thread> collection = semaphore.getQueuedThreads();
        for (Thread t : collection
                ) {
            System.out.println(t.getName());
        }
    }

    static class MySemaphore extends Semaphore {
        public MySemaphore(int permits) {
            super(permits);
        }

        public Collection<Thread> getQueuedThreads() {
            return super.getQueuedThreads();
        }
    }
}
