/**
 *链接：https://www.nowcoder.com/questionTerminal/f0db4c36573d459cae44ac90b90c6212?orderByHotValue=0&page=1&onlyReference=false
 * 来源：牛客网
 *
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 *
 * 输入描述:
 *
 * 每个测试输入包含2个字符串
 *
 *
 * 输出描述:
 *
 * 输出删除后的字符串
 * 示例1
 * 输入
 *
 * They are students.
 * aeiou
 * 输出
 *
 * Thy r stdnts.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeleteChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            String res = del(str1,str2);
            System.out.println(res);
        }
    }
    public static String del(String str1,String str2){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            set.add(str2.charAt(i));
        }
        String res = "";
        for (int i = 0; i < str1.length(); i++) {
            if(!set.contains(str1.charAt(i))){
                res += str1.charAt(i);
            }
        }
        return res;
    }
}
