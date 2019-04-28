package com.ji.concurrency.chapter2;/*
    user ji
    data 2019/3/11
    time 12:09 PM
*/

import java.util.stream.IntStream;

public class WaitSet {
    private final static Object LOCK = new Object();
    /*
    1.所有的对象都会又一个wait set ，用来存放该对象的wait方法，之后进入block状态线程
    2.线程被notify之后，不一定立刻执行
    3.线程从waitset中的唤醒顺序并不一定是FIFO
    4.唤醒之后还是需要去获取锁
     */
    private static void work() {
        /*
        在wait之后释放锁，再次获得锁的时候会根据上次记录的位置继续执行没有执行的命令
         */
        synchronized (LOCK){
            System.out.println("beginning------");
            try {
                System.out.println("Thread will come");
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread will out");
        }
    }
    public static void main(String[] args) {
//        IntStream.range(0, 10).forEach(i -> new Thread(String.valueOf(i)){
//            @Override
//            public void run() {
//                synchronized (LOCK){
//                    try {
//                        System.out.println(Thread.currentThread().getName()+" will come to wait ");
//                        LOCK.wait();
//                        System.out.println(Thread.currentThread().getName()+" will leave  to wait ");
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start());
//        IntStream.range(0,10).forEach(i->{
//            synchronized (LOCK){
//                LOCK.notify();
//                try {
//                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
        new Thread(){
            @Override
            public void run() {
                work();
            }
        }.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (LOCK){
            LOCK.notify();
        }

    }
}
