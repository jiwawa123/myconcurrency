package com.ji.concurrency.chapter4;/*
    user ji
    data 2019/3/11
    time 7:13 PM
*/

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList = new ArrayList();

    public void setState(int state) {
        if (state == this.state) {
            return;
        }
        this.state = state;
        notifyAllObserver();
    }

    private int state;

    public int getState() {
        return this.state;
    }

    public void attach(Observer observer) {
        observerList.add(observer);
    }

    private void notifyAllObserver() {
        for (Observer observer:observerList
             ) {
            observer.update();
        }
    }
}
