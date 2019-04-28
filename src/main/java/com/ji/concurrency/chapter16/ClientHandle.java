package com.ji.concurrency.chapter16;
/*
    user ji
    data 2019/3/13
    time 3:27 PM
*/

import java.io.*;
import java.net.Socket;

public class ClientHandle implements Runnable {
    private final Socket socket;
    private volatile boolean running = true;

    public ClientHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter pw = new PrintWriter(outputStream)) {
            while (running) {
                String message = br.readLine();
                if (message == null)
                    break;
                System.out.println("  come from client  " + message);
                pw.write("echo " + message + "\n");
                pw.flush();
            }
        } catch (IOException e) {
            this.running = false;
        } finally {
            this.stop();
        }

    }

    public void stop() {
        if (!running) {
            return;
        }
        this.running = false;
        try {
            this.socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
