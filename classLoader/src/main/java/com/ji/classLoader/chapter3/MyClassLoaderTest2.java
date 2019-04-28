package com.ji.classLoader.chapter3;/*
    user ji
    data 2019/3/19
    time 2:51 PM
*/

public class MyClassLoaderTest2 {
    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader1");
        classLoader2.setDir("");
        try {
            Class<?> cla = classLoader2.loadClass(" com.ji.classLoader.chapter3.MyObject");
            System.out.println(cla);
            System.out.println(((MyClassLoader)cla.getClassLoader()).getClassLoadName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
