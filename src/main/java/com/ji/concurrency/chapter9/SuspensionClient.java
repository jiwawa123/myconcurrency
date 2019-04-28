package com.ji.concurrency.chapter9;/*
    user ji
    data 2019/3/12
    time 11:19 AM
*/

public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"hello").start();
        ServerThread st  = new ServerThread(requestQueue);
        st.start();
        Thread.sleep(100);
        st.close();
    }
}
