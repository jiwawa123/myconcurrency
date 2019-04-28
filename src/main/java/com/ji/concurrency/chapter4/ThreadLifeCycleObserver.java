package com.ji.concurrency.chapter4;/*
    user ji
    data 2019/3/11
    time 7:51 PM
*/

import java.util.List;

public class ThreadLifeCycleObserver implements LifeCycleListener {

    private static final Object LOCK = new Object();

    public void currencyQuery(List<String> ids) {
        if (ids == null || ids.isEmpty())
            return;
        ids.stream().forEach(i -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("query id " + i);
                    int x = 1 / 0;
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));

                }
            }
        }, i).start());
    }

    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.println("the thread is [" + event.getThread().getName() + "]  state is [" + event.getState() + "]");
            if (event.getCause() != null) {
                System.out.println("the thread is [" + event.getThread().getName() + " failed ");

                event.getCause().printStackTrace();
            }
        }
    }
}
