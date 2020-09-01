package util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class OrderSystemUtil {
    //需要实现读取body的功能
    //需要先把整个body读取出来,然后才能解析成json
    public static String readBody(HttpServletRequest req) throws UnsupportedEncodingException {
        //1.先获取body的长度(单位为字节)
        int length = req.getContentLength();
        byte[] buffer = new byte[length];
        try(InputStream inputStream = req.getInputStream()){
            inputStream.read(buffer,0,length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //重要事项
        //构造String的时候,必须制定编码格式(相当于把字节数据转成字符数据)
        //涉及转换,最好都要加上编码格式
        //不加可能会出错
        return new String(buffer,"UTF-8");
    }
}


