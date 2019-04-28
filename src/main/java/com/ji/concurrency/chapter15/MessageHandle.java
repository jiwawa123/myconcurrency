package com.ji.concurrency.chapter15;/*
    user ji
    data 2019/3/13
    time 9:14 AM
*/

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageHandle {
    private final static Random random = new Random(System.currentTimeMillis());
    private final static Executor executor = Executors.newFixedThreadPool(5 );
    public void request(Message message) {
        executor.execute(()->{
            String value = message.getValue();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + " the message is " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        new Thread(() -> {
//            String value = message.getValue();
//            try {
//                Thread.sleep(random.nextInt(1000));
//                System.out.println(Thread.currentThread().getName() + " the message is " + value);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
    }
    public void shutdown(){
        ((ExecutorService)executor).shutdown();
    }
}
