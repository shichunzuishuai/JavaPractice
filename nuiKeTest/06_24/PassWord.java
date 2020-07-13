/**
 * 链接：https://www.nowcoder.com/questionTerminal/9f6b8f6ec26d44cfb8fc8c664b0edb6b
 * 来源：牛客网
 *
 * NowCoder生活在充满危险和阴谋的年代。为了生存，他首次发明了密码，用于军队的消息传递。
 * 假设你是军团中的一名军官，需要把发送来的消息破译出来、并提
 * 供给你的将军。
 * 消息加密的办法是：对消息原文中的每个字母，分别用该字母之后的第5个字母替换
 * （例如：消息原文中的每个字母A 都分别替换成字母F），其他字符不 变，并且消息原文的所有字母都是大写的。
 * 密码中的字母与原文中的字母对应关系如下。
 * 密码字母：A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * 原文字母：V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
 *
 * 输入描述:
 *
 * 输入包括多组数据，每组数据一行，为收到的密文。
 * 密文仅有空格和大写字母组成。
 *
 *
 * 输出描述:
 *
 * 对应每一组数据，输出解密后的明文。
 * 示例1
 * 输入
 *
 * HELLO WORLD<br/>SNHJ
 * 输出
 *
 * CZGGJ RJMGY<br/>NICE
 */

import java.util.Scanner;
public class PassWord {
    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            while(sc.hasNext()){
                char[] sw=new char[130];
                String str1="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String str2="VWXYZABCDEFGHIJKLMNOPQRSTU";
                for(int i=0;i<str1.length();i++){
                    sw[str1.charAt(i)]=str2.charAt(i);
                }
                String str=sc.nextLine();
                String result="";
                for(int i=0;i<str.length();i++){
                    if(str.charAt(i)==' '){
                        result+=" ";
                    }else{
                        result+=sw[str.charAt(i)];
                    }
                }
                System.out.println(result);
            }
        }
}

//        Scanner scanner = new Scanner(System.in);
//        char[] arr = new char[26];
//        String str = null;
//        String[] str2 = new String[10];
//        int flag = 0;
//        while (scanner.hasNext()) {
//            for (int i = 0; i < 26; i++) {
//                arr[i] = (char) ('A' + i);
//            }
//            //  System.out.print(arr[5]);
//             str = scanner.nextLine();
//            str2[flag] = str;
//            flag++;
//        }
//        String res = word(arr, str2);
//        System.out.println(res + " ");
//    }
//    public static String  word(char[] arr,String[] str2){
//        String res = "";
//        for (int k = 0; k < str2.length; k++) {
//            String str = str2[k];
//            if(str == null){
//                break;
//            }
////            System.out.println(str);
////            System.out.println();
//            for (int i = 0; i < str.length(); i++) {
//                for (int j = 0; j < 26; j++) {
//                    if(str.charAt(i) == ' '){
//                        System.out.print(" ");
//                    }else if(str.charAt(i) == arr[j]){
//                        if(j - 5 < 0){
//                            res += arr[26 - (5 - j)];
//                        }else {
//                            res += arr[j - 5];
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }