package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 2:11 PM
*/

public class AtomicBooleanFlag {
    private static boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
//        new Thread(() -> {
//            while (flag) {
//                try {
//                    Thread.sleep(1000);
//                    //System.out.println("i am working.");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//        Thread.sleep(1000);
//        new Thread(() -> {
//            flag = false;
//        }).start();
    }
}
