package com.ji.concurrency3.utils.Exchanger;/*
    user ji
    data 2019/3/25
    time 9:54 AM
*/

import java.util.concurrent.Exchanger;

public class ExchangerTest2 {
    /*
    Actor 协成
     */
    public static void main(String[] args) {
        final Exchanger<Object> exchanger = new Exchanger<Object>();
        new Thread() {
            @Override
            public void run() {
                Object object = new Object();
                System.out.println("A send the obj" + object);
                try {
                    Object robj = exchanger.exchange(object);
                    System.out.println(robj+" from B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                Object bobj = new Object();
                try {
                    System.out.println("send " + bobj + " from B");
                    Object obj = exchanger.exchange(bobj);
                    System.out.println(obj + " from A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
