package com.ji.concurrency.chapter8;/*
    user ji
    data 2019/3/12
    time 9:55 AM
*/

import java.util.function.Consumer;

public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> futureTask){
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(()->{
            T result = futureTask.call();
            asynFuture.done(result);
        }).start();
        return asynFuture;
    }
    /*
    加入回调的方式实现获取数据
     */
    public <T> Future<T> submit(final FutureTask<T> futureTask, final Consumer<T> consumer){
        AsynFuture<T> asynFuture = new AsynFuture<>();
        new Thread(()->{
            T result = futureTask.call();
            asynFuture.done(result);
            consumer.accept(result);
        }).start();
        return asynFuture;
    }

}
