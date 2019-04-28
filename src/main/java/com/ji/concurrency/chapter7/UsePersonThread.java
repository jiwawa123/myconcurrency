package com.ji.concurrency.chapter7;/*
    user ji
    data 2019/3/12
    time 8:45 AM
*/

public class UsePersonThread extends Thread {
    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}
