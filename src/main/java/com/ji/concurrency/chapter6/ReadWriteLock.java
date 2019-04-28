package com.ji.concurrency.chapter6;/*
    user ji
    data 2019/3/11
    time 10:44 PM
*/

public class ReadWriteLock {

    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private boolean preferWrite = true;

    public ReadWriteLock(boolean preferWrite) {
        this.preferWrite = preferWrite;
    }

    public synchronized void readLock() {
        this.waitingReaders++;
        try {
            while (writingWriters > 0 || (preferWrite && waitingWriters > 0))
                this.wait();
            this.readingReaders++;
            //System.out.println(Thread.currentThread().getName() + " is reading");
            unReadLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.waitingReaders--;
        }
    }

    public synchronized void unReadLock() {
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock() {
        this.waitingWriters++;
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                this.wait();
            }
            this.writingWriters++;
            //System.out.println(Thread.currentThread().getName() + " is writing");
            unWriteLock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.waitingWriters--;
        }
    }

    public synchronized void unWriteLock() {
        this.writingWriters--;
        this.notifyAll();
    }
}
