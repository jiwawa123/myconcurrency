package com.ji.concurrency.chapter17;/*
    user ji
    data 2019/3/13
    time 8:16 PM
*/

import java.util.Random;

public class TransportThread extends Thread {
    private final Channel channel;
    private final static Random random = new Random(System.currentTimeMillis());

    public TransportThread(String name ,Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; true; i++) {
                Request request = new Request(getName(),i );
                this.channel.put(request);
                Thread.sleep(random.nextInt(1000 ));
            }
        }catch (Exception e){

        }
    }
}

