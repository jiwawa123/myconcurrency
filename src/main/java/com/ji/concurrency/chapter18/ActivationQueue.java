package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:40 PM
*/

import java.util.LinkedList;

public class ActivationQueue {
    private final static int MAX_QUEUE = 100;
    private final LinkedList<MethodRequest> linkedList = new LinkedList<>();

    public synchronized void put(MethodRequest methodRequest) {
        while (linkedList.size() >= MAX_QUEUE) {
            try {
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        linkedList.addLast(methodRequest);
        this.notifyAll();
    }

    public synchronized MethodRequest get(){
        while(linkedList.size()==0){
            try{
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        MethodRequest methodRequest = linkedList.removeFirst();
        this.notifyAll();
        return methodRequest;
    }
}

