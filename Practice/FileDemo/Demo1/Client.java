package com.ff.javaNet.Practice.FileDemo.Demo1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端,创建时需要建立连接
        Socket socket = new Socket("127.0.0.1", 8888);


        OutputStream out = socket.getOutputStream(); //获得输出流对象

        System.out.println("正在向服务器发送文件");
        FileInputStream fileInputStreamin = new FileInputStream("D:\\Users\\17509\\Desktop\\111.mp3");
        byte[] b = new byte[10240];
        int length = 0;
        while ((length = fileInputStreamin.read(b)) != -1) {//读取文件内容
            out.write(b, 0, length); //发送给服务器端
        }
        socket.shutdownOutput();
        fileInputStreamin.close();

        //接收服务器端的消息
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String ms = dataInputStream.readUTF();
        if (ms.equals("OK")){
            System.out.println("对方接收成功");
        }
        out.close();
        socket.close();
    }
}
