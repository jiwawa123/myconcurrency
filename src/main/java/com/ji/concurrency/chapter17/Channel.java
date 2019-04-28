package com.ji.concurrency.chapter17;/*
    user ji
    data 2019/3/13
    time 7:58 PM
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class Channel {
    private final static int MAX_COUNT = 100;

    private final Request[] requestsQueue;

    private int head;

    private int tail;

    private int count;

    private final WorkerThread[] workerPool;

    public Channel(int count) {
        requestsQueue = new Request[MAX_COUNT];
        this.workerPool = new WorkerThread[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        init();
    }

    private void init() {
        for (int i = 0; i < workerPool.length; i++) {
            workerPool[i] = new WorkerThread("work" + i, this);
        }
    }

    public void startWork() {
        Arrays.asList(workerPool).forEach(WorkerThread::start);
    }

    public synchronized void put(Request request) {
        while (count >= workerPool.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.requestsQueue[tail++ % requestsQueue.length] = request;
        this.count++;
        this.notifyAll();
    }

    public synchronized Request getRequest() {
        while (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = this.requestsQueue[head];
        this.head = (this.head + 1) % this.requestsQueue.length;
        count--;
        this.notifyAll();
        return request;
    }
}
