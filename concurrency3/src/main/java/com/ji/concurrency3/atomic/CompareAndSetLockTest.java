package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 1:40 PM
*/

public class CompareAndSetLockTest {

    public static void main(String[] args) {
//        for (int i = 0; i < 4; i++) {
//            new Thread(() -> {
//                doSomething();
//            }).start();
//        }
    }

    public static void doSomething() {
        try {
            CompareAndSetLock.tryLock();
            System.out.println(Thread.currentThread() + " get this lock and wait");
            Thread.sleep(1000);
            CompareAndSetLock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            CompareAndSetLock.unlock();
        }
    }
}
