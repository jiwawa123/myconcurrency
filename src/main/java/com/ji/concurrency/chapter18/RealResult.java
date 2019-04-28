package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 9:20 PM
*/

public class RealResult implements Result{
    private final Object resultValue;

    public RealResult(Object resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public Object getResultValue() {
        return this.resultValue;
    }
}
