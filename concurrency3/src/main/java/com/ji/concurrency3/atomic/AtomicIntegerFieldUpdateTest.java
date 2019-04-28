package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 6:50 PM
*/

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.stream.IntStream;

public class AtomicIntegerFieldUpdateTest {
    public static void main(String[] args) {
        final AtomicIntegerFieldUpdater<TestMe> updater =
                AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        final TestMe me = new TestMe();
//        IntStream.range(0, 2).forEach(i -> new Thread(() -> {
//            int max = 20;
//            for (int j = 0; j < max; j++) {
//                int jj = updater.incrementAndGet(me);
//                System.out.println(Thread.currentThread().getName()+" "+jj);
//            }
//        }).start());
    }

    static class TestMe {
        volatile int i;
    }
}
