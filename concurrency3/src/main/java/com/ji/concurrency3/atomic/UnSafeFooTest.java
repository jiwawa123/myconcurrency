package com.ji.concurrency3.atomic;/*
    user ji
    data 2019/3/24
    time 11:18 AM
*/

import sun.misc.Unsafe;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UnSafeFooTest {
    private static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return (Unsafe) f.get(null);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, NoSuchFieldException, IOException, NoSuchMethodException, InvocationTargetException {
//        Simple simple = new Simple();
//        System.out.println(simple.getL());
//        Simple simple1 = Simple.class.newInstance();
//        System.out.println(simple1.getL());
//        Class.forName("com.ji.concurrency3.atomic.UnSafeFooTest$Simple");
        Unsafe unsafe = getUnsafe();
//        Simple simple = (Simple) unsafe.allocateInstance(Simple.class);
//        System.out.println(simple.getL());
//        System.out.println(simple.getClass().getClassLoader());
//        Guard guard = new Guard();
//        guard.work();
//
//        Field f = guard.getClass().getDeclaredField("ACCESS_ALLOWED");
//        unsafe.putInt(guard,unsafe.objectFieldOffset(f),42);
//        guard.work();
//        byte[] con = loadClassContent();
//        Class aclass = unsafe.defineClass(null, con, 0, con.length, null, null);
//        long a = (long) aclass.getMethod("get").invoke(aclass.newInstance(), null);
//        System.out.println(a);
        System.out.println(sizeOf(new Simple()));
    }

    private static long sizeOf(Object object) {
        Unsafe unsafe = getUnsafe();
        Set<Field> fields = new HashSet<Field>();
        Class c = object.getClass();
        while (c != Object.class) {
            Field[] declare = c.getDeclaredFields();
            for (Field f : declare
                    ) {
                if ((f.getModifiers() & Modifier.STATIC) == 0) {
                    fields.add(f);
                }
            }
            c = c.getSuperclass();
        }
        long maxOffSet = 0;
        for (Field f:fields
             ) {
            maxOffSet = Math.max(maxOffSet,unsafe.objectFieldOffset(f));
        }
        return (maxOffSet/8+1)*8;
    }

    private static byte[] loadClassContent() throws IOException {
        File file = new File("/Users/ji/lib/A.class");
        FileInputStream fis = new FileInputStream(file);
        byte content[] = new byte[(int) file.length()];
        fis.read(content);
        return content;
    }

    static class Simple {
        private long l = 0;
        private int i = 0;

        public Simple() {
            this.l = 1;
            System.out.println("=========");
        }

        public long getL() {
            return l;
        }
    }

    static class Guard {
        private int ACCESS_ALLOWED = 1;

        private boolean allow() {
            return 42 == ACCESS_ALLOWED;
        }

        public void work() {
            if (allow()) {
                System.out.println(" i am working ");
            } else {
                System.out.println(" i am not allowed working");
            }
        }
    }
}
