package com.ji.concurrency.chapter10;/*
    user ji
    data 2019/3/12
    time 2:44 PM
*/
/*
始终以当前线程作为key值
 */

public class SimulatorThreadLocalTest {
    private static SimulatorThreadLocal<String> stl = new SimulatorThreadLocal<>();

    public static void main(String[] args) {
//        stl.set(Thread.currentThread().getName());

        Thread t1 = new Thread(()->{
            stl.set(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName()+" "+stl.get());
        });
        t1.start();
        System.out.println(stl.get());
    }
}
