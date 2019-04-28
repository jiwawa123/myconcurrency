package com.ji.concurrency.chapter6;/*
    user ji
    data 2019/3/11
    time 11:17 PM
*/

public class ReadWorker extends Thread {
    private final ShareData data;

    public ReadWorker(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " " + String.valueOf(data.read()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
