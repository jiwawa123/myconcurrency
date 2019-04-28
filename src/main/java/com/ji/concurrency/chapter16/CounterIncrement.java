package com.ji.concurrency.chapter16;/*
    user ji
    data 2019/3/13
    time 9:30 AM
*/

import java.util.Random;

public class CounterIncrement  extends Thread{
    private volatile  boolean terminated = false;
    private int counter = 0;
    private Random random = new Random(System.currentTimeMillis());
    @Override
    public void run() {
        try{
            while(!terminated){
                System.out.println(Thread.currentThread().getName()+" "+ counter++ );
                Thread.sleep(random.nextInt(1000 ));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            clean();
        }
    }
    private void clean(){
        System.out.println("do some clean work for the second phase "+counter);
    }

    public void close(){
        this.terminated = true;
        this.interrupt();
    }
}
