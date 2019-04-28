package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:57 PM
*/

public final class ActiveObjectFactory {
    private ActiveObjectFactory(){

    }
    public static  ActiveObject createActiveObject(){
         Servant servant = new Servant();
         ActivationQueue activationQueue = new ActivationQueue();
         SchedulerThread schedulerThread = new SchedulerThread(activationQueue);
         ActiveObjectProxy proxy =  new ActiveObjectProxy(servant,schedulerThread);
         schedulerThread.start();
         return proxy;
    }
}
