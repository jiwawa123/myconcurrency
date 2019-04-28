package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:14 PM
*/

public class Servant implements ActiveObject {

    @Override
    public Result makeString(int count, char fillChar) {
        char[] chars = new char[count];
        for (int i = 0; i < count; i++) {
            chars[i] = fillChar;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new RealResult(new String(chars));
    }


    @Override
    public void displayString(String text) {
        try {
            System.out.println("Display :" + text);
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
