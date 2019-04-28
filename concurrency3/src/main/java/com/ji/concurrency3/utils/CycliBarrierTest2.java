package com.ji.concurrency3.utils;/*
    user ji
    data 2019/3/25
    time 9:07 AM
*/

import javax.sound.midi.Soundbank;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CycliBarrierTest2 {
    static class MyCountDownLatch extends CountDownLatch {
        private final Runnable runnable;

        public MyCountDownLatch(int count, Runnable runnable) {
            super(count);
            this.runnable = runnable;
        }

        public void countDown() {
            super.countDown();
            if (getCount() == 0) {
                runnable.run();
            }
        }
    }

    public static void main(String[] args) {
        MyCountDownLatch myCountDownLatch = new MyCountDownLatch(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all is ok ");
            }
        });
        new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(100);
                    myCountDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(3);
                    myCountDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
