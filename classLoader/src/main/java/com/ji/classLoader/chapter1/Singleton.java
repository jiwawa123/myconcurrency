package com.ji.classLoader.chapter1;/*
    user ji
    data 2019/3/17
    time 7:13 PM
*/
/*

private static Singleton instance = new Singleton();
在不同的位置，x，y的数值不一样，这是因为他们给静态变量赋予初值的位置不同
 */

public class Singleton {
    private static Singleton instance = new Singleton();
    private static int x = 0;
    private static int y;

    private Singleton() {
        x++;
        y++;
    }

    public Singleton getInstance() {
        return this.instance;
    }

    public static void main(String[] args) {

    }
}
