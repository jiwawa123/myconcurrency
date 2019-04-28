package com.ji.concurrency3.utils;/*
    user ji
    data 2019/3/24
    time 7:38 PM
*/

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
当四个人都在等待的时候表示四个都到达了临界点，这个时候可以执行下一次任务了
 */
public class CycliBarrierTest {
    public static void main(String[] args) {
        int N = 4;
        /*
        通过使用runnable接口实现回调的方式
         */
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("all of finished");
            }
        });
        for (int i = 0; i < N; i++)
            new Writer(barrier).start();
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                long start = System.currentTimeMillis();
                Thread.sleep(new Random(System.currentTimeMillis()).nextInt(2000));      //以睡眠来模拟写入数据操作
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                System.out.println(Thread.currentThread().getName() + " parse1 cost " + (System.currentTimeMillis() - start));
                System.out.println(Thread.currentThread().getName() + " " + cyclicBarrier.getNumberWaiting());

                cyclicBarrier.await();
                long start2 = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + " 开始第二阶段");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " 结束第二阶段");
                System.out.println(Thread.currentThread().getName() + " parse1 cost " + (System.currentTimeMillis() - start2));

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
