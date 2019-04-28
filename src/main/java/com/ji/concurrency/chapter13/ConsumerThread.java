package com.ji.concurrency.chapter13;/*
    user ji
    data 2019/3/12
    time 9:47 PM
*/

import java.util.Random;

public class ConsumerThread extends Thread {
    private final MessageQueue messageQueue;
    private final Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue messageQueue,int i) {
        super("Consumer "+i);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName()+" "+messageQueue.take().getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
