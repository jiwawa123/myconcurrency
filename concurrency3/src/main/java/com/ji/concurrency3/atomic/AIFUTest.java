package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 7:08 PM
*/

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AIFUTest {
    private volatile int i;
    private AtomicIntegerFieldUpdater<AIFUTest> updater
            = AtomicIntegerFieldUpdater.newUpdater(AIFUTest.class,"i");
    public void update(int newValue){
        updater.compareAndSet(this,i,newValue);
    }
    public int get(){
        return i;
    }

    public static void main(String[] args) {
        AIFUTest aifuTest = new AIFUTest();
        aifuTest.update(5);
        System.out.println(aifuTest.get());

    }
}
