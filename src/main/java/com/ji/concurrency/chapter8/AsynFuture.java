package com.ji.concurrency.chapter8;/*
    user ji
    data 2019/3/12
    time 9:57 AM
*/

public class AsynFuture<T> implements Future<T> {
    private volatile boolean done = false;
    private T result;

    public void done(T result) {
        synchronized (this){
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this) {
            while (!done) {
                this.wait();
            }
        }
        return result;
    }
}
