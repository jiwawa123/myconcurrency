package com.ji.concurrency.chapter4;/*
    user ji
    data 2019/3/11
    time 7:26 PM
*/

public class ObserverClient {
    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("==================");
        subject.setState(10);

        System.out.println("==================");
        subject.setState(5);

        System.out.println("==================");
        subject.setState(5);


    }
}
