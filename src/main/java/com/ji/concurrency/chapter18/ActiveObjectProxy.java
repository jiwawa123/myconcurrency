package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:53 PM
*/

public class ActiveObjectProxy implements ActiveObject {
    private final Servant servant;
    private final SchedulerThread schedulerThread;

    public ActiveObjectProxy(Servant servant, SchedulerThread schedulerThread) {
        this.servant = servant;
        this.schedulerThread = schedulerThread;
    }

    @Override
    public Result makeString(int count, char fillChar) {
        FutureResult futureResult = new FutureResult();
        schedulerThread.invoke(new MakeStringRequest(servant,futureResult, count,fillChar ));
        return futureResult;
    }

    @Override
    public void displayString(String text) {
        schedulerThread.invoke(new DisplayStringRequest(servant,text));
    }
}
