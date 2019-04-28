package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 10:02 PM
*/

public class DisplayStringClient extends Thread {
    private final ActiveObject activeObject;

    public DisplayStringClient(String name,ActiveObject activeObject) {
        super(name );
        this.activeObject = activeObject;
    }

    @Override
    public void run() {
        for (int i = 0; true  ; i++) {
            String text = Thread.currentThread().getName()+" => "+i;
             activeObject.displayString(text);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
