/**
 * 链接：https://www.nowcoder.com/questionTerminal/81544a4989df4109b33c2d65037c5836
 * 来源：牛客网
 *
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 *
 * 4、每个单词最长20个字母；
 *
 * 输入描述:
 *
 * 输入一行以空格来分隔的句子
 *
 *
 * 输出描述:
 *
 * 输出句子的逆序
 * 示例1
 * 输入
 *
 * I am a student
 * 输出
 *
 * student a am I
 */

import java.util.Scanner;

public class WordReversedPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String res = print(str);
            System.out.println(res);
        }
    }
    public static String print(String str){
        String res2 = "";
        if(str == " "){
            return " ";
        }
        String res = "";
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if(c >= 65 && c <= 90 || c >= 97 && c <= 122){
                res += (c);
            }else {
                res += " ";
            }
        }
        String[] arr = res.split(" ");
        for (int i = 0; i < arr.length -1; i++) {
            sb.append(arr[i]);
            sb.reverse();
            res2 += (sb + " ");
            sb.delete(0,sb.length());
        }
        sb.append(arr[arr.length - 1]);
        sb.reverse();
        res2 += sb;
        return res2;
    }
}
