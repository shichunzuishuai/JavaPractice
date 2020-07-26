/**
 * 1、对输入的字符串进行加解密，并输出。
 * 2加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 *
 * 接口描述：
 *     实现接口，每个接口实现1个基本操作：
 * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 * 说明：
 * 1、字符串以\0结尾。
 * 2、字符串最长100个字符。
 *
 * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 * 说明：
 * 1、字符串以\0结尾。
 *     2、字符串最长100个字符。
 *
 *
 *
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 * 示例1
 * 输入
 *
 * 复制
 * abcdefg
 * BCDEFGH
 * 输出
 *
 * 复制
 * BCDEFGH
 * abcdefg
 */

import java.util.Scanner;
public class Encryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String res = encryption(str1);
            System.out.println(res);
            String res2 = decode(str2);
            System.out.println(res2);
        }
    }
    public static String encryption(String str){
        String res = "";
        char ret = ' ';
        char a = ' ';
        char b = ' ';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                 ret = (char) (c + 1);
                 if(ret > '9'){
                     ret = '0';
                 }
                 res += ret;
            }else if(c >= 'A' && c <= 'Z'){
                ret = (char) (c + 1);
                if(ret > 'Z'){
                    ret = 'A';
                }
                 a =  (char)(c + ret % 26);
                 b = Character.toLowerCase(ret);
               res += b;
            }else if(c >= 'a' && c <= 'z'){
                ret = (char) (c + 1);
                if(ret > 'z'){
                    ret = 'a';
                }
                a =  (char)(c + ret % 26);
                b = Character.toUpperCase(ret);
                res += b;
            }
        }
        return res;
    }
    public static String decode(String str){
        String res = "";
        char ret = ' ';
        char a = ' ';
        char b = ' ';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                ret = (char) (c - 1);
                if(ret < '0'){
                    ret = '9';
                }
                res += ret;
            }else if(c >= 'A' && c <= 'Z'){
                ret = (char) (c - 1);
                if(ret < 'A'){
                    ret = 'Z';
                }
                a =  (char)(c + ret % 26);
                b = Character.toLowerCase(ret);
                res += b;
            }else if(c >= 'a' && c <= 'z'){
                ret = (char) (c - 1);
                if(ret < 'a'){
                    ret = 'z';
                }
                a =  (char)(c + ret % 26);
                b = Character.toUpperCase(ret);
                res += b;
            }
        }
        return res;
    }
}
