package com.ff.javaNet.Day2.Demo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4567);
        System.out.println("等待连接");
        Socket sss = ss.accept();
        System.out.println("连接成功");

        Scanner input = new Scanner(System.in);
        /*接收客户端发过来的信息*/
        DataInputStream dataInputStream = new DataInputStream(sss.getInputStream());
        String ms = dataInputStream.readUTF();
        System.out.println("客户端说了句:" + ms);

        /*向客户端发送信息*/
        DataOutputStream dataOutputStream = new DataOutputStream(sss.getOutputStream());
        System.out.println("向客户端说:");
        String s = input.next();
        dataOutputStream.writeUTF(s);


    }
}
