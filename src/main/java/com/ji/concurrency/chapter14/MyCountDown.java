package com.ji.concurrency.chapter14;/*
    user ji
    data 2019/3/13
    time 9:02 AM
*/

public class MyCountDown {
    private final int total;
    private int counter = 0;
    public MyCountDown(int total) {
        this.total = total;
    }

    public void down(){
        synchronized (this){
            counter++;
            notifyAll();
        }
    }
    public void await() throws InterruptedException {
        synchronized (this){
            while(counter!=total){
                this.wait();
            }
        }
    }
}
