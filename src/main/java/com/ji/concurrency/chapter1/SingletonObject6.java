package com.ji.concurrency.chapter1;/*
    user ji
    data 2019/3/11
    time 10:43 AM
*/

import java.util.stream.IntStream;

public class SingletonObject6 {


    private SingletonObject6() {
        //empty
    }
    /*
    内部类只有在使用的过程中才会被主动加载，如果不使用就不会被加载
     */
    private static class InstanceHolder{
        private final static SingletonObject6 instance = new SingletonObject6();
    }
    public static SingletonObject6 getIntance(){
        return InstanceHolder.instance;
    }

    public static void main(String[] args) {
        IntStream.range(0,100).forEach(i->new Thread(String.valueOf(i)){
            @Override
            public void run() {
                System.out.println(SingletonObject6.getIntance());
            }
        }.start());
    }
}
