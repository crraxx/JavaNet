package com.ff.javaNet.Practice.FileDemo.Demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

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

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\Users\\17509\\Desktop\\1111.mp3");
        byte[] b = new byte[10240];
        int length = 0;
        while ((length = in.read(b)) != -1) {//读取文件内容
            fileOutputStream.write(b, 0, length); //发送给服务器端
        }
        fileOutputStream.flush();//刷新
        fileOutputStream.close();

        //接收完以后服务器端向客户端发送消息"ok"
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF("OK");
    }
}
