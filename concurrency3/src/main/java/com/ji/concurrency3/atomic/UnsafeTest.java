package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 9:04 PM
*/

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnsafeTest {
    /*

     */
    public static void main(String[] args) throws InterruptedException {
//        Unsafe unsafe = getUnsafe();
//        System.out.println(unsafe);
        ExecutorService service = Executors.newFixedThreadPool(1000);
        Counter counter = new CASCounter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            service.submit(new CounterRunnable(counter,10000));
        }
        service.shutdown();
        service.awaitTermination(1,TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("Counter result :" +counter.getCounter());
        System.out.println("time passed "+(end - start));
    }

    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    interface Counter {
        void increment();

        long getCounter();
    }
    /*
    没有加锁的情况
     */
    static class StupidCounter implements Counter{
        private long counter = 0;
        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }
    /*

     */
    static class CASCounter implements Counter{
        private volatile long counter = 0;
        private Unsafe unsafe;
        private long offset;

        public CASCounter() {
            this.unsafe = getUnsafe();
            try {
                this.offset = unsafe.objectFieldOffset(CASCounter.class.getDeclaredField("counter"));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void increment() {
            long current = counter;
            while(!unsafe.compareAndSwapLong(this,offset,current,current+1)){
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }
    /*
    原子性
     */
    static class AtomicCounter implements Counter{
        private AtomicLong counter = new AtomicLong();
        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }
    /*
    synchronized 关键字加锁的情况
     */
    static class SyncCounter implements Counter{
        private long counter = 0;
        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }
    static class LockCounter implements Counter{
        private long counter = 0;
        private final Lock lock = new ReentrantLock();
        @Override
        public  void increment() {
            try{
                lock.lock();
                counter++;
                lock.unlock();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }
    static class CounterRunnable implements Runnable {
        private final Counter counter;
        private final int num;

        CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }
}
