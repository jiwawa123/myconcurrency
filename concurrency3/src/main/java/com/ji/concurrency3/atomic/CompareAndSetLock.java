package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 1:36 PM
*/

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSetLock {
    private final static AtomicInteger value = new AtomicInteger(0);
    private static Thread lockedThread;

    public static void tryLock() throws Exception {
        boolean success = value.compareAndSet(0, 1);
        if (!success) {
            throw new Exception(Thread.currentThread().getName() + " get the lock failed");
        } else {
            lockedThread = Thread.currentThread();
        }
    }

    public static void unlock() {
        if (0 == value.get())
            return;
        if (lockedThread == Thread.currentThread())
            value.compareAndSet(1, 0);
    }
}
