package com.ji.concurrency.chapter16;/*
    user ji
    data 2019/3/13
    time 9:40 AM
*/



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppServer extends Thread {
    private int port;
    private static final int DEFAULT_PORT = 80;

    private volatile boolean start = true;
    /*
    通过创建线程池的方式实现可以实现多个用户都可以顺利连接到服务器，最多多少个用户同时访问这个服务器资源
     */
    private final  ExecutorService executor = Executors.newFixedThreadPool(2);
    private List<ClientHandle > clientThread = new ArrayList<>();

    private static ServerSocket server;
    public AppServer(int port) {
        this.port = port;
    }

    public AppServer() {
        this(DEFAULT_PORT);

    }

    @Override
    public void run() {
        try {
             server = new ServerSocket(port);
            while (start) {
                Socket client = server.accept();
                ClientHandle clientHandle = new ClientHandle(client);
                executor.submit(clientHandle);
                this.clientThread.add(clientHandle);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            this.dispose();
        }
    }

    private void dispose() {
        this.clientThread.stream().forEach(c-> {
            c.stop();
        });
        this.executor.shutdown();
    }

    public void startServer() throws IOException {


    }

    public void shutdown() {
        this.start = false;
        try {
            this.interrupt();
            this.server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
