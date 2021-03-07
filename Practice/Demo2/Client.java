package com.ff.javaNet.Practice.Demo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 4567);
        Scanner input = new Scanner(System.in);

        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

        while (true){
            System.out.println("向服务器端发送信息:");
            String s = input.next();
            dataOutputStream.writeUTF(s);

            String ms = dataInputStream.readUTF();
            System.out.println("服务器端回复:" + ms);

            if (ms.equals("拜拜")){
                break;
            }
        }
        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
    }
}
