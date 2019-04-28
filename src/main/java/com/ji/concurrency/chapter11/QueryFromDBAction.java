package com.ji.concurrency.chapter11;/*
    user ji
    data 2019/3/12
    time 7:46 PM
*/


public class QueryFromDBAction {

    public void execute() {
        try {
            Thread.sleep(1000);
            ActionContext.getActionContext().getContext().setName("ji "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
