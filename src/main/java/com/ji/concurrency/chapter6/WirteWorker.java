package com.ji.concurrency.chapter6;/*
    user ji
    data 2019/3/11
    time 11:08 PM
*/

import java.util.Random;

public class WirteWorker extends Thread {
    private static final Random radom = new Random(System.currentTimeMillis());
    private final ShareData data;
    private final String filler;

    private int index = 0;

    public WirteWorker(ShareData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char c = nextChar();
                data.write(c);
                Thread.sleep(radom.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private char nextChar() {
        char c = filler.charAt(index);
        index++;
        if (index >= filler.length())
            index = 0;
        return c;
    }
}
