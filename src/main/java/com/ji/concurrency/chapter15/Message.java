package com.ji.concurrency.chapter15;/*
    user ji
    data 2019/3/13
    time 9:12 AM
*/

public class Message {
    private final String value;

    public Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
