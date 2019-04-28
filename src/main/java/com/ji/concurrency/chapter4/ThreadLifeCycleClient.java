package com.ji.concurrency.chapter4;/*
    user ji
    data 2019/3/11
    time 8:02 PM
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ThreadLifeCycleClient {
    public static void main(String[] args) {

        ThreadLifeCycleObserver   tlco = new ThreadLifeCycleObserver();
        List<String> str = Arrays.asList("id1","id2");
        tlco.currencyQuery(str );
    }
}
