package com.ji.concurrency.chapter5;/*
    user ji
    data 2019/3/11
    time 10:25 PM
*/

import java.util.stream.IntStream;

public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        IntStream.range(0,3).forEach(i->new User(i+"name",i+"address",gate){

        }.start());

    }
}
