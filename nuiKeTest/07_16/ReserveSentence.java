/**
 *自己写的不太好,要看看课件
 *
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * 将一个英文语句以单词为单位逆序排放。
 *
 *
 * 输出描述:
 *
 * 得到逆序的句子
 * 示例1
 * 输入
 *
 * I am a boy
 * 输出
 *
 * boy a am I
 */

import java.util.Scanner;

public class ReserveSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            print(arr);
            System.out.println();
        }
    }
    public static void print(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[arr.length - 1 - i] + " ");
        }
    }
}
