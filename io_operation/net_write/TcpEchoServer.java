package net_write;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpEchoServer {
    //1.初始化服务器
    //2.进入循环
    //  1.)先从内核中获取获取一个tc的连接
    //  2.)处理这个连接
    //      a)读取请求并解析
    //      b)根据请求计算响应
    //      c)把这个响应写回客户端

    private ServerSocket serverSocket = null;

    public TcpEchoServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
           // 1.)先从内核中获取获取一个tc的连接
            Socket clientSocket =  serverSocket.accept();
            //  2.)处理这个连接
            processConnection(clientSocket);
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        //通过clientSocket来和客户端交互,获取到clientSocket中的流对象
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
