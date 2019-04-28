package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 4:13 PM
*/

import java.util.concurrent.atomic.AtomicStampedReference;

/*
多线程在对象进行创建的时候不能保证对象的原子性
最快失败策略
 */
public class AtomicReferenceTest {
    private static AtomicStampedReference<Integer> atomic = new AtomicStampedReference<>(100, 0);

    public static void main(String[] args) throws InterruptedException {

//        Thread t1 = new Thread(() -> {
//            try {
//                Thread.sleep(1);
//                System.out.println(atomic.compareAndSet(100, 101, atomic.getStamp(), atomic.getStamp() + 1));
//                System.out.println(atomic.compareAndSet(101, 100, atomic.getStamp(), atomic.getStamp() + 1));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            try {
//                int stamp = atomic.getStamp();
//                System.out.println("before " + stamp);
//                Thread.sleep(2);
//                System.out.println(atomic.compareAndSet(100, 101, stamp, stamp + 1));
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
    }

    static class Simple {
        private String name;
        private int age;

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + age;
        }
    }
}
