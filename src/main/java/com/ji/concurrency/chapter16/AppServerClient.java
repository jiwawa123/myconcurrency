package com.ji.concurrency.chapter16;/*
    user ji
    data 2019/3/13
    time 3:47 PM
*/

public class AppServerClient  {
    public static void main(String[] args) throws InterruptedException {
        AppServer appServer = new AppServer(1027);
        appServer.start();
        Thread.sleep(150_000L);
        appServer.shutdown();
    }
}
