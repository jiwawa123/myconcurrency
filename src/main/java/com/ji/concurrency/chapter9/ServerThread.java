package com.ji.concurrency.chapter9;/*
    user ji
    data 2019/3/12
    time 11:12 AM
*/

import java.util.Random;

public class ServerThread extends Thread {
    private final RequestQueue queue;
    private final Random random;
    private volatile boolean flag = true;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (flag) {
            Request request = queue.getRequest();
            if(null==request){
                System.out.println(" receive empty ");
                continue;
            }
            System.out.println("server  -> " + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close() {
        this.flag = false;
        this.interrupt();
    }
}
