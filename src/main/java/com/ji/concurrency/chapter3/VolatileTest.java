package com.ji.concurrency.chapter3;/*
    user ji
    data 2019/3/11
    time 2:06 PM
*/

public class VolatileTest {
    private  volatile static int INIT_VALUE = 0;
    private final static int MAX_LIMIT = 5;

    public static void main(String[] args) {
        /*
        如果不实用volatile关键字，那么就很难实现同步更新
         */
        new Thread(() -> {
            int local = INIT_VALUE;
            while (local < MAX_LIMIT) {
                if (local != INIT_VALUE) {
                    System.out.printf("this local value update to  [%d] \n", INIT_VALUE);
                    local = INIT_VALUE;
                }


            }
        }, "read").start();
        new Thread(() -> {
            int local = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("this init value update to  [%d] \n", ++local);
                INIT_VALUE = local;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "update").start();
    }
}
