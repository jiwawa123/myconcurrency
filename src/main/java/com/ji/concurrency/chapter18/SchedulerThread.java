package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:46 PM
*/

public class SchedulerThread extends Thread{
    private final ActivationQueue activationQueue ;

    public SchedulerThread(ActivationQueue activationQueue) {
        this.activationQueue = activationQueue;
    }
    public void invoke(MethodRequest request ){
        this.activationQueue.put(request);
    }
    @Override
    public void run() {
        while(true){
            activationQueue.get().execute();

        }
    }
}
