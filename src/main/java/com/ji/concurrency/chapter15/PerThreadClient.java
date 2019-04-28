package com.ji.concurrency.chapter15;/*
    user ji
    data 2019/3/13
    time 9:17 AM
*/

import java.util.stream.IntStream;

public class PerThreadClient {
    public static void main(String[] args) {
        final MessageHandle messageHandle = new MessageHandle();
        IntStream.range(0, 100).
                forEach(i -> messageHandle.
                        request(new Message(String.valueOf(i))));
        messageHandle.shutdown();
    }
}
