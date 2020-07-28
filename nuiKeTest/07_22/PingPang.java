/**
 * 链接：https://www.nowcoder.com/questionTerminal/bb4f1a23dbb84fd7b77be1fbe9eaaf32
 * 来源：牛客网
 *
 * nowcoder有两盒（A、B）乒乓球，有红双喜的、有亚力亚的……现在他需要判别A盒是否包含了B盒中所有的种类，并且每种球的数量不少于B盒中的数量，该怎么办呢？
 *
 * 输入描述:
 *
 * 输入有多组数据。
 * 每组数据包含两个字符串A、B，代表A盒与B盒中的乒乓球，每个乒乓球用一个大写字母表示，即相同类型的乒乓球为相同的大写字母。
 * 字符串长度不大于10000。
 *
 *
 * 输出描述:
 *
 * 每一组输入对应一行输出：如果B盒中所有球的类型在A中都有，并且每种球的数量都不大于A，则输出“Yes”；否则输出“No”。
 * 示例1
 * 输入
 * ABCDFYE CDE<br/>ABCDGEAS CDECDE
 * 输出
 *
 * Yes<br/>No
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PingPang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            clc(arr);
        }
    }
    public static void clc(String[] arr){
        String str1 = arr[0];
        String str2 = arr[1];
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            Integer count = map.get(c);
            if(count == null){
                map.put(c,1);
            }else {
                map.put(c,count + 1);
            }
        }
//        for (Map.Entry<Character,Integer> entry: map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            Integer count = map1.get(c);
            if(count == null){
                map1.put(c,1);
            }else {
                map1.put(c,count + 1);
            }
        }
//        for (Map.Entry<Character,Integer> entry: map1.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        boolean flg = false;
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if(!map.containsKey(c) || map.get(c) < map1.get(c)){
                flg = false;
                System.out.println("No");
                break;
            }else {
                flg = true;
            }
        }
        if(flg == true){
            System.out.println("Yes");
        }
    }
}
