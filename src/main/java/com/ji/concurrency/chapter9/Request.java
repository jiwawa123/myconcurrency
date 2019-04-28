package com.ji.concurrency.chapter9;/*
    user ji
    data 2019/3/12
    time 11:02 AM
*/

public class Request  {
    final private String value;

    public Request(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
