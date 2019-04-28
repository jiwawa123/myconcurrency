package com.ji.concurrency.chapter4;/*
    user ji
    data 2019/3/11
    time 7:14 PM
*/

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
