package com.ji.concurrency.chapter1;/*
    user ji
    data 2019/3/11
    time 10:36 AM
*/

public class SingletonObject1 {
    /*
    can't not lazy load
     */
    private static final SingletonObject1 instance = new SingletonObject1();
    private SingletonObject1(){
        //empty
    }
    public SingletonObject1 getInstance(){
        return instance;
    }
}
