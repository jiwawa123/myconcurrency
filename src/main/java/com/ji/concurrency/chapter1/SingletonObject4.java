package com.ji.concurrency.chapter1;/*
    user ji
    data 2019/3/11
    time 10:43 AM
*/

public class SingletonObject4 {
    private static SingletonObject4 instance;

    private SingletonObject4() {
        //empty
    }

    //最多两个线程同时到达的时候才会考虑加锁的情况
    public static SingletonObject4 getInstance() {
        if (instance == null) {
            synchronized (SingletonObject4.class) {
                if (instance == null)
                    instance = new SingletonObject4();
            }
        }

        return instance;
    }
}
