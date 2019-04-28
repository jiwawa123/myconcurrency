package com.ji.concurrency3.utils.Exchanger;/*
    user ji
    data 2019/3/25
    time 9:31 AM
*/

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExchangerTest1 {
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<String>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " starts");
                try {
                    String res = exchanger.exchange("I am from T-A",10,TimeUnit.SECONDS);
                    System.out.println(res);
                    System.out.println("T-A is done");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }
        }, "===A===").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " starts");
                try {
                    TimeUnit.SECONDS.sleep(20);
                    String res = exchanger.exchange("I am from T-B");
                    //System.out.println(res);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "===B===").start();
    }
}
