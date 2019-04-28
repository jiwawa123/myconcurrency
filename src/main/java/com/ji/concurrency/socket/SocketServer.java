package com.ji.concurrency.socket;/*
    user ji
    data 2019/3/13
    time 6:35 PM
*/

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws Exception {
        // 监听指定的端口
        int port = 1027;
        ServerSocket server = new ServerSocket(port);
        // server将一直等待连接的到来
        System.out.println("server将一直等待连接的到来");
        Socket socket = server.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter pw = new PrintWriter(outputStream);
        try {
            while (true) {
                String message = br.readLine();
                System.out.println("from client -> " + message);
                pw.write("from server - >" + message + "\n");
                pw.flush();
            }
        } catch (IOException e) {
            inputStream.close();
            socket.close();
            server.close();
        }

    }
}
