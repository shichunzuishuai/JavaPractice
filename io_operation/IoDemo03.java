package io_operation;

import java.io.*;

//带有缓冲区域的BufferedInputStream
public class IoDemo03 {
    public static void main(String[] args) {
        copyFile2();
    }
    public static void copyFile() throws IOException {
    //使用BufferedInputStream和BufferedOutputStream时要先创建 FileInputStream 和 FileOutputStream;
        FileInputStream fileInputStream = new FileInputStream("d:/test_dir/pubg.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/test_dir/pubg.jpg2");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = bufferedInputStream.read(buffer)) != -1){
            bufferedOutputStream.write(buffer,0,len);
        }
        // 此处涉及到四个流对象~~
        // 调用这一组 close 时, 就会自动关闭内部包含的 FileInputStream 和 FileOutputStream
        // 此处不需要写 四次 关闭~~
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    public static void copyFile2(){
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/test_dir/pubg.jpg"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/test_dir/pubg.jpg2"))) {
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bufferedInputStream.read(buffer)) != -1){
                System.out.println("len: " + len);
                bufferedOutputStream.write(buffer,0,len);
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
    //方法2和方法 3 的效果是一样的,只不过喊了一种写法
    public static void copyFile3(){
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/test_dir/pubg.jpg"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/test_dir/pubg.jpg2"))) {
            byte[] buffer = new byte[1024];
            int len = -1;
           while (true){
               len = bufferedInputStream.read(buffer);
               if (len == -1){
                   break;
               }
               bufferedOutputStream.write(buffer,0,len);
           }

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
}
