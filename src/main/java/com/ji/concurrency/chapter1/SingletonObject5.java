package com.ji.concurrency.chapter1;/*
    user ji
    data 2019/3/11
    time 10:43 AM
*/

public class SingletonObject5 {
    private static volatile  SingletonObject5 instance;

    private SingletonObject5() {
        //empty
    }

    //double check add volatile
    public static SingletonObject5 getInstance() {
        if (instance == null) {
            synchronized (SingletonObject5.class) {
                if (instance == null)
                    instance = new SingletonObject5();
            }
        }

        return instance;
    }
}
