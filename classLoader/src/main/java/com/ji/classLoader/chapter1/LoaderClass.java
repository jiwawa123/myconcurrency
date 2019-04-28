package com.ji.classLoader.chapter1;/*
    user ji
    data 2019/3/17
    time 9:10 PM
*/

public class LoaderClass {
    public static void main(String[] args) {
        /*
        四个实例对应一个class
         */
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();

        System.out.println(myObject1.getClass() == myObject2.getClass());
    }
}

class MyObject {

    static{
         x = 0;
        System.out.println();
    }
    /*
    定义的位置决定了你能在一开始的时候能不能进行相应的写操作
     */
    private  static int x = 10;
}
