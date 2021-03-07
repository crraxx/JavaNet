package com.ff.javaNet.Practice.Demo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4567);
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("等待客户端连接");
            Socket sss = ss.accept();
            System.out.println("连接客户端成功");
            DataInputStream dataInputStream = new DataInputStream(sss.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(sss.getOutputStream());
            while (true) {
                String ms = dataInputStream.readUTF();
                System.out.println("接收到客户端的消息:" + ms);

                System.out.println("向客户端发送消息:");
                String s = input.next();
                dataOutputStream.writeUTF(s);
                if (s.equals("拜拜")) {
                    break;
                }
            }
            sss.close();
            dataOutputStream.close();
            dataInputStream.close();

        }
    }
}
