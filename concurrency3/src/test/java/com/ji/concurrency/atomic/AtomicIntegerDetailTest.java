package com.ji.concurrency.atomic;/*
    user ji
    data 2019/3/23
    time 12:46 PM
*/

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class AtomicIntegerDetailTest {

    @Test
    public void testCreate() {

    }

    @Test
    public void testCreateWith(){
        AtomicBoolean bool = new AtomicBoolean(true);
        System.out.println(bool.compareAndSet(true,false));
        System.out.println(bool.get());
    }
    @Test
    public void Along(){
        assertEquals(1,1);
    }


}
