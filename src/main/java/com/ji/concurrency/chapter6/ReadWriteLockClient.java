package com.ji.concurrency.chapter6;/*
    user ji
    data 2019/3/11
    time 11:21 PM
*/
/*
    ReadWriteLOCK design pattern[读写锁模式]
    Reader-Writer design pattern[读写模式]
 */
public class ReadWriteLockClient {
    public static void main(String[] args) {
        final ShareData data = new ShareData(20);
        new ReadWorker(data).start();
        new ReadWorker(data).start();

        new WirteWorker(data,"thisisatest").start();
        new WirteWorker(data,"THISISATEST").start();

    }
}
