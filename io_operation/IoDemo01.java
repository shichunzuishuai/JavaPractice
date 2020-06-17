package io_operation;

import sun.awt.windows.WPrinterJob;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class IoDemo01 {
    public static void main(String[] args) throws IOException {
        //文件操作
//        File file = new File("d:/test.txt");
//        //判断是否存在
//        System.out.println(file.exists());
//        //判断是否为普通文件
//        System.out.println(file.isFile());
//        //判断是否为目录文件
//        System.out.println(file.isDirectory());
//        file.delete();
//        System.out.println(file.exists());
        //创建一个新的文件
//        file.createNewFile();
//        System.out.println(file.exists());

        //目录操作
//        File file = new File("d:/test_dir/1/2/3/4");
//        System.out.println(file.exists());
//        System.out.println(file.isDirectory());
//        file.mkdirs();
//        System.out.println(file.exists());
//        System.out.println(file.getParent());

        //listFiles
        File file = new File("d:/test_dir");
//        File[] files = file.listFiles();
//        for (File x: files) {
//            System.out.println(x);
//        }
        listAllFiles(file);
    }
    //递归罗列一个目录中的所有文件
    private static void listAllFiles(File f){
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for ( File x: files) {
                listAllFiles(x);
            }
        }else {
            System.out.println(f);
        }
    }
}
