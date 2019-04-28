package com.ji.concurrency.chapter10;/*
    user ji
    data 2019/3/12
    time 2:27 PM
*/

public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal(){
        @Override
        protected String initialValue() {
            return "ji";
        }
    };

    //JVM create main thread
    public static void main(String[] args) throws InterruptedException {
//
        Thread.sleep(1000L);
        System.out.println(threadLocal.get());
    }
}
