package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/23
    time 12:40 PM
*/
/*
在使用jit 1.8版本以上会对线程进行相应的优化， 如果线程里面没有任何东西就不执行
 */
public class JITTest {
    private volatile  static boolean init = false;
    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            while(!init){
//                System.out.println("");
//            }
//        }).start();
//        Thread.sleep(1000);
//
//        new Thread(()->{
//            init = true;
//            System.out.println("this init is true");
//        }).start();
    }
}
