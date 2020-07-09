/**
 * 链接：https://www.nowcoder.com/questionTerminal/8e89aa5561514b478c5ef50f2e66e76c
 * 来源：牛客网
 * 旧键盘上坏了几个键，于是在敲一段文字的时候，对应的字符就不会出现。现在给出应该输入的一段文字、以及坏掉的那些键，打出的结果文字会是怎样？
 * 输入描述:
 * 输入在2行中分别给出坏掉的那些键、以及应该输入的文字。其中对应英文字母的坏键以大写给出；每段文字是不超过10^5个字符的串。可用的字符包括字母[a-z, A-Z]、数字0-9、以及下划线“_”（代表空格）、“,”、“.”、“-”、“+”（代表上档键）。题目保证第2行输入的文字串非空。
 * 注意：如果上档键坏掉了，那么大写的英文字母无法被打出。
 * 输出描述:
 * 在一行中输出能够被打出的结果文字。如果没有一个字符能被打出，则输出空行。
 * 示例1
 * 输入
 * 7+IE.
 * 7_This_is_a_test.
 * 输出
 * _hs_s_a_tst
 */
import java.util.*;
public class BrokenKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            String str2 = scanner.nextLine();
            char[] arr = new char[str2.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = str2.charAt(i);
            }
            broken(str1,arr);
        }
    }
    public static void broken(String str1,char[] arr){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set.add(str1.charAt(i));
        }
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(Character.toUpperCase(arr[i]))
                || set.contains(arr[i]) || set.contains('+') && arr[i] >= 65 && arr[i] <= 90){
                arr[i] = '>';
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '>'){
                continue;
            }else {
                System.out.print(arr[i]);
            }
        }
        System.out.println();
    }
}








//
//        public static void broken(String str1,String str2){
//            Set<Character> set = new HashSet<>();
//            for (int i = 0; i < str1.length(); i++) {
//            set.add(str1.charAt(i));
//        }
//            StringBuilder sb = new StringBuilder();
//            sb.append(str2);
//            String str3 = str2.toUpperCase();
//            for (int i = 0; i < str3.length(); i++) {
//                if(set.contains(str3.charAt(i))){
//                    sb.charAt(i) = 't'
//                }
//            }
//            for (int i = 0; i < sb.length(); i++) {
//                if(set.contains('+') && sb.charAt(i) >= 65 && sb.charAt(i) <= 90){
//                    sb.charAt(i) = ''
//                }
//            }
//    }

















