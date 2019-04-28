package com.ji.concurrency.atomic;/*
    user ji
    data 2019/3/23
    time 6:33 PM
*/

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

import static junit.framework.TestCase.assertEquals;

public class AtomicIntegerArrayTest {
    @Test
    public void testCreateAtomicIntegerArray(){
        /*
        有点类似于list 但是又和list不同
         */
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        assertEquals(10,array.length());
        for (int i = 0; i < array.length(); i++) {
            System.out.println(array.get(i));
        }
        array.set(3,2);
        System.out.println(array.get(3));
    }

}
