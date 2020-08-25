/**
 *统计回文:
 * “回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。
 * 花花非常喜欢这种拥有对称美的回文串，生日的时候她得到两个礼物分别是字符串A和字符串B。
 * 现在她非常好奇有没有办法将字符串B插入字符串A使产生的字符串是一个回文串。你接受花花的请求，
 * 帮助她寻找有多少种插入办法可以使新串是一个回文串。如果字符串B插入的位置不同就考虑为不一样的办法。
 * 例如：
 * A = “aba”，B = “b”。这里有4种把B插入A的办法：
 * 在A的第一个字母之前: "baba" 不是回文
 * 在第一个字母‘a’之后: "abba" 是回文
 * 在字母‘b’之后: "abba" 是回文
 * 在第二个字母'a'之后 "abab" 不是回文
 * 所以满足条件的答案为2
 * 输入
 *
 * aba
 * b
 * 输出
 *
 * 2
 */

import java.util.Scanner;

public class StatisticsHuiWen {
    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        // while (scanner.hasNext()){
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        StringBuilder sb = new StringBuilder(A);
        //注意 i<= A.length();因为插入的方式
        for(int i = 0; i <= A.length(); i++){
            //把不可修改的String变为可修改的StringBuilder类型

            //将B插入A中
            sb.insert(i,B);
            if(isHuiWen(sb.toString())){
                count++;
            }
            sb.replace(0,sb.length(),A);
        }
        //   }
        System.out.println(count);
    }
    public static Boolean isHuiWen(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
