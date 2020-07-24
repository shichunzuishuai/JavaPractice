/**
 * 代码有问题
 *
 * 链接：https://www.nowcoder.com/questionTerminal/655a43d702cd466093022383c24a38bf
 * 来源：牛客网
 *
 * 给定一个字符串，问是否能通过添加一个字母将其变为回文串。
 *
 * 输入描述:
 *
 * 一行一个由小写字母构成的字符串，字符串长度小于等于10。
 *
 *
 * 输出描述:
 *
 * 输出答案(YES\NO).
 * 示例1
 * 输入
 *
 * coco
 * 输出
 *
 * YES
 */

import java.util.Scanner;

public class HuiWen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            boolean res = isHuiWen(str);
            System.out.println(res);
        }
    }
    public static boolean isHuiWen(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < str.length(); i++) {
            sb.deleteCharAt(i);
//            for (int j = 0; j < sb.length() ; j++) {
//                if(sb.charAt(i) != sb.charAt(sb.length() - 1 - i)){
//                    System.out.println(flag+ "f");
//                    break;
//                }else {
//                    System.out.println(flag + "t");
//                    flag = true;
//                }
//            }
            StringBuilder str2 = sb.reverse();
            System.out.println(str2);
            System.out.println(sb);
            boolean flag = str2.equals(sb);
            if(flag == true){
                return true;
            }
            sb.insert(i,str.charAt(i));
        }
        return false;
    }
}
