/**
 * 链接：https://www.nowcoder.com/questionTerminal/8f3df50d2b9043208c5eed283d1d4da6
 * 来源：牛客网
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * 输出描述:
 * 输出该数值的十进制字符串。
 * 示例1
 * 输入
 * 0xA
 * 输出
 * 10
 */

import java.util.Scanner;
public class ChangeNums {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //不要前面的0X
            String str=sc.nextLine().substring(2);
            int sum=0;
            char[] arr =str.toUpperCase().toCharArray();
            for (int i =0; i < arr.length; i++) {
                if(arr[i]>='0'&&arr[i]<='9')
                    sum+=(arr[i]-'0')*Math.pow(16,arr.length - 1 - i);
                if(arr[i]>='A'&&arr[i]<='F')
                    sum+=(arr[i]-'A'+10)*Math.pow(16,arr.length - 1 - i);
            }
            System.out.println(sum);
        }
    }
}