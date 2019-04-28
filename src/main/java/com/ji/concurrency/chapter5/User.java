package com.ji.concurrency.chapter5;/*
    user ji
    data 2019/3/11
    time 10:22 PM
*/

public class User extends Thread {
    private final String myName;
    private final String myAddress;
    private final Gate gate;

    public User(String myName, String myAddress, Gate gate) {
        this.myName = myName;
        this.myAddress = myAddress;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(this.myName + "   BEGIN");
        while (true) {
            this.gate.pass(myName, myAddress);
        }
    }
}
