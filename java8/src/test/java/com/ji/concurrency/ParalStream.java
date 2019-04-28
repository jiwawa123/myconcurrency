package com.ji.concurrency;/*
    user ji
    data 2019/4/2
    time 1:23 PM
*/

import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParalStream {
    //计算100000个数字的累加和，比较parallel的并行化程度
    @Test
    public void countPara() {
        long count = 0;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            count += i;
        }
        //直接比较stream 与 parallel并行流会发现并行流会节约很多时间
//        Long tmp1 = LongStream.rangeClosed(1, 100000)
//                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        long end1 = System.currentTimeMillis();
        Integer tmp2 = IntStream.rangeClosed(1, 100000)
                .parallel()
                .reduce(0, Integer::sum);
        System.out.println(System.currentTimeMillis() - end1);
    }
}
