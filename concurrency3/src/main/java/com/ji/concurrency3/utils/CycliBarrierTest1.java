package com.ji.concurrency3.utils;/*
    user ji
    data 2019/3/24
    time 7:38 PM
*/

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/*
当四个人都在等待的时候表示四个都到达了临界点，这个时候可以执行下一次任务了
 */
public class CycliBarrierTest1 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        TimeUnit.MICROSECONDS.sleep(100);
        cyclicBarrier.reset();
    }
}
