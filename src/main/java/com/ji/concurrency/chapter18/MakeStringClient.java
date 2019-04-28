package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 10:05 PM
*/

public class MakeStringClient extends Thread {
    private final ActiveObject activeObject;
    private final char fillChar;

    public MakeStringClient(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
        this.fillChar = name.charAt(0);
    }

    @Override
    public void run() {
        for (int i = 0; true; i++) {
            Result result = activeObject.makeString(i + 1, fillChar);
            try {
                Thread.sleep(20);
                System.out.println(Thread.currentThread().getName() + "  " + (String ) result.getResultValue());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
