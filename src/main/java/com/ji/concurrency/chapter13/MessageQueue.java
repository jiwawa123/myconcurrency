package com.ji.concurrency.chapter13;/*
    user ji
    data 2019/3/12
    time 9:33 PM
*/

import java.util.LinkedList;

public class MessageQueue {
    private static LinkedList<Message> queue = new LinkedList<Message>();

    private final static int DEFAULT_MAX = 100;

    private final int limit;

    public MessageQueue(final int limit) {
        this.limit = limit;
    }

    public void put(Message message) throws InterruptedException {
        synchronized (queue) {
            while (queue.size() >= limit) {
                queue.wait();
            }
            queue.addLast(message);
            queue.notifyAll();
        }
    }

    public Message take() throws InterruptedException {
        synchronized (queue) {
            while (queue.isEmpty()) {
                queue.wait();
            }
            Message message = queue.removeFirst();
            queue.notifyAll();
            return message;
        }
    }

    public int getMaxLimit() {
        return this.limit;
    }

    public int getQueueSize() {
        synchronized (queue) {
            return queue.size();
        }
    }
}
