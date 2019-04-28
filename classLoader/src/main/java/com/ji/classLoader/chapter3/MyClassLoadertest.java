package com.ji.classLoader.chapter3;/*
    user ji
    data 2019/3/19
    time 2:21 PM
*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoadertest {
    public static void main(String[] args) {
        MyClassLoader classLoader = new MyClassLoader( "MyClassLoader");
        try {
            Class<?> cla = classLoader.loadClass("com.ji.classLoader.chapter3.MyObject");
            System.out.println(cla);
            System.out.println(cla.getClassLoader());
            Object obj = cla.newInstance();
            Method method = cla.getMethod("hello",new Class<?>[]{});
            Object result = method.invoke(obj,new Object[]{});
            System.out.println(result.toString() );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
