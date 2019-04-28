package com.ji.concurrency.chapter7;/*
    user ji
    data 2019/3/12
    time 9:29 AM
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        School school = new School();
        System.out.println(school.getList());
        List<String> l = school.getList();
        l.add("t1");
        System.out.println(school.getList());
        l.add("t2");
        System.out.println(school.getList());
    }

}
