package com.ji.concurrency.chapter1;/*
    user ji
    data 2019/3/11
    time 10:43 AM
*/

public class SingletonObject2 {
    private static SingletonObject2 instance;

    private SingletonObject2() {
        //empty
    }

    public static SingletonObject2 getInstance() {
        if (instance == null)
            return new SingletonObject2();
        return instance;
    }
}
