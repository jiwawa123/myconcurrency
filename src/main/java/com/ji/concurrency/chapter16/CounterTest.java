package com.ji.concurrency.chapter16;/*
    user ji
    data 2019/3/13
    time 9:37 AM
*/

public class CounterTest  {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        Thread.sleep(10);
        counterIncrement.close();
    }
}
