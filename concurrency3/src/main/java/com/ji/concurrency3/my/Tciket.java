package com.ji.concurrency3.my;/*
    user ji
    data 2019/3/24
    time 2:34 PM
*/

import sun.misc.Lock;

import java.util.stream.IntStream;

public class Tciket {
    public static void main(String[] args) {
        TicketRunnable ticketRunnable = new TicketRunnable();
        IntStream.range(0, 4).forEach(i -> new Thread(ticketRunnable).start());
    }


}

class TicketRunnable implements Runnable {
    private volatile int index = 0;
    Lock lock = new Lock();

    @Override
    public void run() {
        while (index < 50) {
            try {
                lock.lock();
                index++;
                System.out.println(Thread.currentThread().getName() + " is giving ticket[" + index + "]");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}