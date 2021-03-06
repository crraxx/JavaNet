package com.ff.javaNet.Day2.UdpDemo3;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    /*
    udp只管发送,不需要提前建立连接
     */
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        //封装数据包/报
        Scanner input = new Scanner(System.in);
        String str = input.next();
        byte[] b = str.getBytes("utf-8");
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        DatagramPacket datagramPacket = new DatagramPacket(b,0,b.length,inetAddress,9999);
        datagramSocket.send(datagramPacket);//发送数据

    }
}
