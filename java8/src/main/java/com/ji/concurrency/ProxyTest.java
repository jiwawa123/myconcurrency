package com.ji.concurrency;/*
    user ji
    data 2019/3/31
    time 12:47 PM
*/

import java.lang.reflect.Proxy;
import java.util.function.Function;

public class ProxyTest {
    public static void main(String[] args) {
        Function function = (Function) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(),
                new Class[]{Function.class},
                (p,m,a)->{
                    return "ji";
        });
        System.out.println(function.apply("hello "));
    }
}
