package com.ff.javaNet.Day2.Demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("等待连接");
        //服务器监听等待链接的客户端请求连接
        Socket socket = serverSocket.accept();//阻塞式 监听
        System.out.println("连接成功");

        //接收客户端的信息
        InputStream in = socket.getInputStream();
        byte[] b = new byte[1024];
        int length = in.read(b);//将客户端的信息写入byte数组中

        //转字符串
        String s = new String(b, 0, length, "utf-8");
        System.out.println("来自客户端的信息:" + s);

        //服务器端向客户端发送消息
        OutputStream out = socket.getOutputStream();
        out.write("我已收到".getBytes("utf-8"));
    }
}
