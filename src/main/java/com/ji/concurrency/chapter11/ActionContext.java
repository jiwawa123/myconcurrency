package com.ji.concurrency.chapter11;/*
    user ji
    data 2019/3/12
    time 8:06 PM
*/

public final class ActionContext {
    private static ThreadLocal<Context> threadLocal = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new Context();
        }
    };
    private static class Singleton{
        private final static ActionContext actionContext = new ActionContext();

    }
    public Context getContext(){
        return threadLocal.get() ;
    }
    public static ActionContext getActionContext(){
        return Singleton.actionContext;
    }

}
