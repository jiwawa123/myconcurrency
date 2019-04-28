package com.ji.concurrency.chapter18;/*
    user ji
    data 2019/3/13
    time 8:39 PM
*/
/*
接受异步消息的主动对象
 */

public interface ActiveObject {
    Result makeString(int count ,char fillChar);

    void displayString(String text);

}
