package com.ji.concurrency3.utils.Exchanger;/*
    user ji
    data 2019/3/25
    time 9:54 AM
*/

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ExchangerTest3 {
    /*
    Actor 协成
     */
    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<Integer>();
        new Thread() {
            @Override
            public void run() {
                AtomicReference<Integer> value = new AtomicReference<>(1);
                try{
                    while(true){
                        value.set(exchanger.exchange(value.get()));
                        System.out.println("==A=="+value.get());
                        TimeUnit.SECONDS.sleep(3);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                AtomicReference<Integer> value = new AtomicReference<>(0);
                try{
                    while(true){
                        value.set(exchanger.exchange(value.get()));
                        System.out.println("==B=="+value.get());
                        TimeUnit.SECONDS.sleep(3);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
