package com.ji.concurrency.chapter10;/*
    user ji
    data 2019/3/12
    time 2:40 PM
*/

import java.util.HashMap;
import java.util.Map;

public class SimulatorThreadLocal<T>  {
    private final Map<Thread,T> storeage = new HashMap();
    public void set(T t){
        synchronized (this){
            Thread key = Thread.currentThread();
            storeage.put(key,t);
        }
    }
    public T get(){
        synchronized (this){
            return storeage.getOrDefault(Thread.currentThread(),null);
        }
    }
}
