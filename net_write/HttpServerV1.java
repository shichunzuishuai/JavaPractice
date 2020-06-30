package net_write;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServerV1 {
    private ServerSocket serverSocket = null;

    public HttpServerV1(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动");
        ExecutorService executorService = Executors.newCachedThreadPool();
        while (true) {
            Socket clientSocket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    process(clientSocket);
                }
            });
        }
    }

    private void process(Socket clientSocket) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))){
            //下面的操作要按照http的协议来进行操作
            //1.读取请求并解析
            //  a)解析首行,并将三个部分用空格来区分开
            String FirstLine = bufferedReader.readLine();
            String[] FirstLineTokens = FirstLine.split(" ");
            String method = FirstLineTokens[0];
            String url = FirstLineTokens[1];
            String version = FirstLineTokens[2];
            //  b)解析header,按行读取,按照冒号空格来分割键值对
            Map<String,String> headers = new HashMap<>();
            String line = "";
            while ( (line = bufferedReader.readLine()) != null && line.length() != 0){
                String[] headerTokens = line.split(": ");
                headers.put(headerTokens[0],headerTokens[1]);
            }
            //  c)解析body(暂时先不考虑)
            //请求解析完毕,加上一个日志
            System.out.printf("%s %s %s\n",method,url,version);
            for (Map.Entry<String,String> entry: headers.entrySet()) {
                System.out.println(entry.getKey() + entry.getValue());
            }
            System.out.println();
            //2.根据请求计算响应
            //此处比较无脑,不管客户端写入啥,都返回一个hello的html
            String resp = "";
            if(url.equals("/ok")){
                bufferedWriter.write(version + "200 OK\n");
                resp = "<h1>hello</h1>";
            }
            else if(url.equals("/notfound")){
                bufferedWriter.write(version + "404 Not Found\n");
                resp = "<h1>Not Found</h1>";
            } else if(url.equals("/seeother")){
                bufferedWriter.write(version + " 303 See Other\n");
                bufferedWriter.write("Location: http://www.sogou.com\n");
                resp = "";
            }
            else {
                bufferedWriter.write(version + "200 OK\n");
                resp = "<h1>default</h1>";
            }
            //3.把响应写回客户端
            bufferedWriter.write(version + "200 OK\n");
            bufferedWriter.write("Content-Type : text/html\n");
            //bufferWriter写入的是字节,所以要先转换成byte,否则写入的字符的长度
            bufferedWriter.write("Content-Length : " + resp.getBytes().length + "\n");
            bufferedWriter.write("\n");
            bufferedWriter.write(resp);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HttpServerV1 serverV1 = new HttpServerV1(9090);
        serverV1.start();
    }
}
