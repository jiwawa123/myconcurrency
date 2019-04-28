package com.ji.concurrency.chapter9;/*
    user ji
    data 2019/3/12
    time 11:02 AM
*/

import java.util.LinkedList;

public class RequestQueue {
    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return  null;
                }
            }
            return queue.removeFirst();
        }

    }

    public void putRequest(Request request) {
        synchronized (queue) {
            queue.addLast(request);
            queue.notifyAll();
        }
    }
}
