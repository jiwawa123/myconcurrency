package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 8:36 PM
*/

public class ActiveObjectTest {
    /*
    active object
    接受异步
     */
    public static void main(String[] args) {
        System.gc();
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakeStringClient("ji", activeObject).start();
        new MakeStringClient("wa", activeObject).start();
        new MakeStringClient("yes ", activeObject).start();
        new DisplayStringClient("hello", activeObject).start();
    }
}
