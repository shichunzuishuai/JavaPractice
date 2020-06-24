package net_write;

import com.sun.javaws.ui.UpdateDialog;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDitServe extends UdpEchoServe{
    private Map<String,String> map = new HashMap<>();
    public UdpDitServe(int port) throws SocketException {
        super(port);
        map.put("cat","小猫");
        map.put("dog","小狗");
        map.put("duck","鸭子");
    }

    @Override
    public String process(String request) {
        return map.getOrDefault(request,"这超出了知识范围");
    }

    public static void main(String[] args) throws IOException {
       UdpDitServe serve = new UdpDitServe(9090);
       serve.start();;
    }
}
