package com.ji.concurrency.chapter11;/*
    user ji
    data 2019/3/12
    time 7:47 PM
*/

public class Context {
    private String name;
    private String address;

    public String getAddress() {
        return address;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
