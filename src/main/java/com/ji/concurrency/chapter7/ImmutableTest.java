package com.ji.concurrency.chapter7;/*
    user ji
    data 2019/3/12
    time 9:07 AM
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {
    private final int age;
    private final String name;
    private final List<String> list;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }


    public ImmutableTest(int age, String name) {
        this.age = age;
        this.name = name;
        this.list = new ArrayList<>();
    }
}
