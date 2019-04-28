package com.ji.concurrency.chapter4;/*
    user ji
    data 2019/3/11
    time 7:25 PM
*/

public class OctalObserver extends Observer {

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    public void update() {
        System.out.println("OctalObserver String "+Integer.toOctalString(subject.getState()));
    }

}
