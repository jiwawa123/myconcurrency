package com.ji.concurrency.chapter13;/*
    user ji
    data 2019/3/12
    time 9:53 PM
*/

import java.util.stream.IntStream;

public class Client {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(10);
        IntStream.range(0,20).forEach(i->new ProduceThread(messageQueue,i).start());
        IntStream.range(0,5).forEach(i->new ConsumerThread(messageQueue,i).start());

    }
}
