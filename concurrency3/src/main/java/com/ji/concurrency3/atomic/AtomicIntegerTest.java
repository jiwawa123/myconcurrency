package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 12:04 PM
*/

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    /*
    volatile
    1.可见性
    2.顺序性
    3.不能保证原子性

   unsafe  保证了高并发的原子性
   lock free
     */
    private static  AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        HashSet<AtomicInteger> hashSet = new HashSet<>();
//        new Thread(()->{
//            int x = 0;
//            while(x<500){
//                hashSet.add(value);
//                int v = value.get();
//                value.getAndIncrement();
//                x++;
//            }
//        }).start();
//        new Thread(()->{
//            int x = 0;
//            while(x<500){
//                hashSet.add(value);
//                int v = value.get();
//                value.getAndIncrement();
//                x++;
//            }
//        }).start();
//        try {
//            Thread.sleep(100);
//            System.out.println(hashSet.size());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

}
