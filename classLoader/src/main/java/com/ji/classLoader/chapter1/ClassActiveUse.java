package com.ji.classLoader.chapter1;/*
    user ji
    data 2019/3/17
    time 3:39 PM
*/

import java.util.Random;

public class ClassActiveUse {
    static {
        System.out.println("ClassActiveUse");
    }
    public static void main(String[] args) {
//        new Obj();
//        System.out.println(I.i);
//        try {
//            Class obj = Class.forName("com.ji.classLoader.chapter1.Obj");
//        } catch (ClassNotFoundException e) {
//
//        }
//        System.out.println(Child.age);
        System.out.println(Obj.str);
    }
}

class Obj {
    protected static final String str = new String("hello");
    static {
        System.out.println("obj 被初始化");
    }
}

class Child extends Obj {
    protected static int age = 23;

    static {
        System.out.println("child 被初始化");
    }
}

interface I {
    int i = 0;
}
