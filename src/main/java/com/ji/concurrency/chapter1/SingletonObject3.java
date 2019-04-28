package com.ji.concurrency.chapter1;/*
    user ji
    data 2019/3/11
    time 10:43 AM
*/

public class SingletonObject3 {
    private static SingletonObject3 instance;

    private SingletonObject3() {
        //empty
    }

    public synchronized static SingletonObject3 getInstance() {
        if (instance == null)
            return new SingletonObject3();
        return instance;
    }
}
