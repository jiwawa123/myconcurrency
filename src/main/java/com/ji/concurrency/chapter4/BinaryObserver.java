package com.ji.concurrency.chapter4;/*
    user ji
    data 2019/3/11
    time 7:21 PM
*/

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject ) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("BinaryObserver String "+Integer.toBinaryString(subject.getState()));
    }
}
