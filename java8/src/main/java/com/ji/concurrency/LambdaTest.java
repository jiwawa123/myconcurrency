package com.ji.concurrency;/*
    user ji
    data 2019/3/31
    time 10:39 AM
*/

@FunctionalInterface
public interface LambdaTest {
    void SysHello(String name);
    String toString();
    default void SysHi(String name){
        System.out.println(name+" hi ");
    }
}
