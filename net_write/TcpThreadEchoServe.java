package net_write;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpThreadEchoServe {
    private ServerSocket serverSocket = null;

    public TcpThreadEchoServe(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        while (true){
            Socket clientSocket = serverSocket.accept();
            //针对这个连接,单独创建一个线程来处理
            Thread t = new Thread(){
                @Override
                public void run() {
                    processConnection(clientSocket);
                }
            };
            t.start();
        }
//        //1.从内核中获取一个连接
//        Socket clientSocket = serverSocket.accept();
//        //2.处理这个连接
//        processConnection(clientSocket);
    }

    private void processConnection(Socket clientSocket) {
        //打印日志
        System.out.printf("[%s:%d]客户端上线\n",clientSocket.getInetAddress().toString(),
                clientSocket.getPort());
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            while (true) {
                //1.
                String request = bufferedReader.readLine();
                //2.
                String response = process(request);
                //3.
                bufferedWriter.write(response + "\n");
                bufferedWriter.flush();
                System.out.printf("[%s:%d] req: %s; resp: %s\n",clientSocket.getInetAddress().toString(),
                        clientSocket.getPort(), request,response);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.printf("[%s:%d]客户端下线\n",clientSocket.getInetAddress().toString(),
                    clientSocket.getPort());
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpThreadEchoServe serve = new TcpThreadEchoServe(9090);
        serve.start();
    }
}
