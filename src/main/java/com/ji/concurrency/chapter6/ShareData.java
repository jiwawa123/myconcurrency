package com.ji.concurrency.chapter6;/*
    user ji
    data 2019/3/11
    time 10:56 PM
*/

public class ShareData {
    private final char[] buffer;

    private final ReadWriteLock lock = new ReadWriteLock(true);

    public ShareData(int len) {
        this.buffer = new char[len];
        for (int i = 0; i < len; i++) {
            this.buffer[i] = '#';
        }
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return this.doRead();
        } finally {
            lock.unReadLock();
        }
    }

    private char[] doRead() throws InterruptedException {
        char[] newBuffer = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }

        return newBuffer;
    }
    public void write(char c) throws InterruptedException{
         try{
             lock.writeLock();
             doWrite(c);
         }finally {
             lock.unWriteLock();
         }
    }
    private void doWrite(char c) throws InterruptedException{
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
        }
    }
}
