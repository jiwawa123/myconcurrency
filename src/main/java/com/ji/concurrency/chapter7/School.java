package com.ji.concurrency.chapter7;/*
    user ji
    data 2019/3/12
    time 9:30 AM
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {
    private final List<String> list;

    public School() {
        this.list = new ArrayList<>();
    }

    public List<String> getList() {
        return list;
    }
}
