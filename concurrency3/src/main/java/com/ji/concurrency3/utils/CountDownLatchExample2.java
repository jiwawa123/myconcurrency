package com.ji.concurrency3.utils;/*
    user ji
    data 2019/3/24
    time 3:11 PM
*/

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample2 {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(){
            @Override
            public void run() {
                System.out.println("do some initial working");
                try{
                    Thread.sleep(1000);
                    latch.await();
                    System.out.println("do other working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            public void run(){
                try {
                    System.out.println("b thread ");
                    latch.await();
                    System.out.println(" ok all ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("syn do some initial working");
                try{
                    Thread.sleep(2000);
                    System.out.println("data prepare for done.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    latch.countDown();
                }
            }
        }.start();
    }
}
