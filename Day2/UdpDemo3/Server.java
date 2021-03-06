package com.ff.javaNet.Day2.UdpDemo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] b= new byte[1024];

        DatagramPacket datagramPacket= new DatagramPacket(b,b.length);
        datagramSocket.receive(datagramPacket);//接收数据
        //datagramPacket.getLength()实际向数组中装入的长度
        String s = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(s);
    }
}
