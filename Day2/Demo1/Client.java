package com.ff.javaNet.Day2.Demo1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端,创建时需要建立连接
        Socket socket = new Socket("127.0.0.1", 8888);

        //获得输出流对象
        OutputStream out = socket.getOutputStream();
        System.out.println("向服务器发送的内容:");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        out.write(s.getBytes("utf-8"));

        //客户端收到服务器端的消息
        InputStream in = socket.getInputStream();
        byte [] b= new byte[1024];
        int length = in.read(b);
        String ms = new String(b,0,length,"utf-8");
        System.out.println("接收到服务器端的信息:"+ms);

        out.close();
        socket.close();
    }
}
