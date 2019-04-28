package com.ji.concurrency.chapter17;/*
    user ji
    data 2019/3/13
    time 8:00 PM
*/

public class Request  {
    private final String name;
    private final int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
    public void execute(){
        System.out.println(Thread.currentThread().getName()+" is doing this "+ this.toString());
    }
    @Override
    public String toString() {
        return "Request{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
