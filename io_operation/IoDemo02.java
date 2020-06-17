package io_operation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDemo02 {
    public static void main(String[] args) throws IOException {
        copyFile("d:/test_dir/pubg.jpg","d:/test_dir/pubg2.jpg");
    }
    public static void copyFile(String srcPath, String destPath) throws IOException {
        //1.先打开文件,才能够读取内容
        FileInputStream fileInputStream  = new FileInputStream(srcPath);
        FileOutputStream fileOutputStream = new FileOutputStream(destPath);
        //2.读取srcPath文件中的内容
        //单词读取的内容是存在上限的,要想把文件读完,必须搭配循环使用
        byte[] buffer = new byte[1024];
        int len = -1;
        //如果读到len是-1;就说明循环结束,读取完毕了
        while ((len = fileInputStream.read(buffer)) != -1){
            // 读取成功, 就把读到的内容写入到另外一个文件中即可.
            // 因为 len 的值不一定就是和缓冲区一样长~
            //3.把读取到的内容写入到destPath文件中
            fileOutputStream.write(buffer,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
