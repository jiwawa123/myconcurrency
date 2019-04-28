package com.ji.concurrency.chapter11;/*
    user ji
    data 2019/3/12
    time 7:46 PM
*/


public class QueryFromHttpAction {

    public void execute() {
        try {
            Thread.sleep(1000);
            Context context = ActionContext.getActionContext().getContext();
            context.setAddress("Beijing");
            System.out.println(Thread.currentThread().getName() + "  " + context.getAddress());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
