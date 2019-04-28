package com.ji.concurrency.chapter17;/*
    user ji
    data 2019/3/13
    time 8:00 PM
*/


import java.util.Random;

public class WorkerThread extends Thread{
    private final Channel channel;
    private final static Random random = new Random(System.currentTimeMillis());
    public WorkerThread(String s, Channel channel) {
        super(s);
        this.channel = channel;
    }

    @Override
    public void run() {
        while(true){
            Request request = channel.getRequest();
            request.execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {

            }
        }
    }
}