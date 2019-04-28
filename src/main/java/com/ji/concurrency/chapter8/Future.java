package com.ji.concurrency.chapter8;/*
    user ji
    data 2019/3/12
    time 9:53 AM
*/

public interface Future<T> {
    T get() throws InterruptedException;
}
