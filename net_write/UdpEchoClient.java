package net_write;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpEchoClient {
    //客户端的流程主要分成四部
    //  1.从用户这里读取数据
    //  2.构造请求发送给服务器
    //  3.从服务器读取响应
    //  4.把相应写到客户端
    private DatagramSocket socket = null;
    private String serveIp;
    private int servePort;

    public UdpEchoClient(String serveIp,int servePort) throws SocketException {
        this.serveIp = serveIp;
        this.servePort = servePort;
        socket = new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            //  1.从用户这里读取数据
            System.out.print("->");
            String request = scanner.nextLine();
            if(request.equals("exit")){
                break;
            }
            //  2.构造请求发送给服务器
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(serveIp),servePort);
            socket.send(requestPacket);
            //  3.从服务器读取响应
            DatagramPacket responsePacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String response = new String(responsePacket.getData(),0,responsePacket.getLength());
            //  4.把相应写到客户端
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}


