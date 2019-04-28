package com.ji.concurrency;/*
    user ji
    data 2019/3/31
    time 6:58 PM
*/

public class ForeachAndIntStream {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int arr[] = new int[100000];
        for (int i = 0; i < 100000; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        for (int k:arr
             ) {
            System.out.print(k);
        }
        System.out.println();
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - end);


    }
}
