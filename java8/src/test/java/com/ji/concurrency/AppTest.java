package com.ji.concurrency;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.function.Function;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    public interface TestMethods {
        String get();
    }

    public String sayHello(String name) {
        return name + "  hello";
    }

    @Test
    public void test() {
        //直接将代码的实现放在里lambda表达式中
        //实例方法引用
        AppTest appTest = new AppTest();
        Function<String, String> function = appTest::sayHello;
        System.out.println(function.apply("ji"));
    }

    @Test
    public void test1() {
        AppTest appTest = new AppTest();
        TestMethods tm = String ::new;
    }
}
