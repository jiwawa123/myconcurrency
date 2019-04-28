package com.ji.concurrency.chapter17;/*
    user ji
    data 2019/3/13
    time 8:25 PM
*/

public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWork();
        new TransportThread("transport", channel).start();
        new TransportThread("ji", channel).start();
        new TransportThread("czh", channel).start();

    }
}
