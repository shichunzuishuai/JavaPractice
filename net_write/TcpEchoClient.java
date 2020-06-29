package net_write;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    //1.启动客户端,和服务器建立连接
    //2.进入主循环
    //  a)读取客户输入的内容
    //  b)构造一个请求发送给服务器
    //  c)读取服务器返回的响应
    //  d)把相应显示到界面上
    private Socket socket = null;

    public TcpEchoClient(String serverIp, int servePort) throws IOException {
        //此处实例化socket,就是在建立tcp连接
         socket = new Socket(serverIp,servePort);

    }
    public void start(){
        //1.启动客户端,和服务器建立连接
        System.out.println("客户端启动");
        Scanner scanner = new Scanner(System.in);
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            //2.进入主循环
            while (true){
                //  a)读取客户输入的内容
                System.out.println("->");
                String request = scanner.nextLine();
                if("exit".equals(request)){
                    break;
                }
                //  b)构造一个请求发送给服务器
                bufferedWriter.write(request + "\n");
                bufferedWriter.flush();
                //  c)读取服务器返回的响应
                String response = bufferedReader.readLine();
                //  d)把相应显示到界面上
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
