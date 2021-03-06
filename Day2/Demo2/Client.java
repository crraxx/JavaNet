package com.ff.javaNet.Day2.Demo2;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        //创建客户端,创建时需要连接
        Socket socket = new Socket("127.0.0.1", 4567);

        //获取输出字节流
        Scanner input = new Scanner(System.in);

        /*向服务器发送信息 */
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("向服务器端说:");
        String s = input.next();
        dataOutputStream.writeUTF(s);


        /*接收客户端发过来的信息*/
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String ms = dataInputStream.readUTF();
        System.out.println("服务器端说了句:" + ms);
    }
}
