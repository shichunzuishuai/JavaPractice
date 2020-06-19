package io_operation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IoDemo02 {
    public static void main(String[] args) throws IOException {
        copyFile2("d:/test_dir/pubg.jpg","d:/test_dir/pubg2.jpg");
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
    //针对上面方法有以下几点不完善的地方
    //1.不一定会执行到close 方法,因为抛出异常就结束了,不会调用close 方法,所以加了一个finally
    //加了finally可能会出现错误,比如fileInputStream 和fileOutputStream为空,此时会出现空异常
    //所以要再次加入if判定
    public static void copyFile2(String srcPath, String destPath)  {
        //1.先打开文件,才能够读取内容
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try{
            fileInputStream  = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
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
        }  catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fileInputStream != null){
                    fileInputStream.close();
                }
                if(fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //2方法相对已经很完善了,但是代码的结构很不好看,还需改进
    //这是最终的代码
    public static void copyFile3()  {
        //代码写成这种就不用了调用close 方法了
        //try语句执行结束后,会自动调用close方法
        try (FileInputStream fileInputStream = new FileInputStream("d:/test_dir/pubg.jpg");
             FileOutputStream fileOutputStream  = new FileOutputStream("d:/test_dir/pubg2.jpg")){
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
