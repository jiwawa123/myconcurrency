package com.ji.concurrency.chapter7;/*
    user ji
    data 2019/3/12
    time 8:58 AM
*/

public class TestString {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str.hashCode());
        String str2 = str;
        //System.out.println(str.hashCode());
        System.out.println(str2.hashCode());
    }
}
