package com.ji.concurrency.chapter13;/*
    user ji
    data 2019/3/12
    time 9:47 PM
*/

import java.util.Random;

public class ProduceThread extends Thread {
    private final MessageQueue messageQueue;
    private final Random random = new Random(System.currentTimeMillis());

    public ProduceThread(MessageQueue messageQueue,int i) {
        super("Produce "+i);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                messageQueue.put(new Message("hello" + Thread.currentThread().getName()));
                System.out.println(Thread.currentThread().getName()+" is putting message");
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
