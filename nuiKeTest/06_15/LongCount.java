import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  链接：https://www.nowcoder.com/questionTerminal/5821836e0ec140c1aa29510fd05f45fc
 *  来源：牛客网
 * 请设计一个算法完成两个超长正整数的加法。
 *  输入参数：
 *  String addend：加数
 *  String augend：被加数
 *  返回值：加法结果
 * 输入两个字符串数字
 * 输出描述:
 * 输出相加后的结果，string型
 * 示例1
 * 输入
 * 99999999999999999999999999999999999999999999999999
 * 1
 * 输出
 * 100000000000000000000000000000000000000000000000000
 */
public class LongCount {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            String str1 = scanner.nextLine();
//            String str2 = scanner.nextLine();
//           int[] ret =  printString(str1,str2);
//            System.out.println(Arrays.toString(ret));
//        }
//    }
//    public static int[] printString(String str1,String str2){
//         char[] a1 = str1.toCharArray();
//         char[] a2 = str2.toCharArray();
//         char[] b1 = new char[a1.length];
//         char[] b2 = new char[a2.length];
//
//        int[] res = new int[a1.length +1];
//        for(int i=0;i<a1.length;i++){
//            b1[i]=a1[a1.length-1-i];
//        }
//        //将输入值2进行翻转存储
//        for(int i=0;i<a2.length;i++){
//            b2[i]=a2[a2.length-1-i];
//        }
//
//        if (b1.length > b2.length) {
//            for(int i = 0; i < b2.length; i++){
//                int sum = b1[i] +b2[i];
//                if(sum > 10){
//                    b1[i + 1]++;
//                }
//                res[i] = sum % 10;
//            }
//            for(int j = b2.length; j < b1.length; j++){
//                res[j] = b1[j];
//            }
//        }
//        for(int i=0;i<res.length;i++){
//            res[i]=res[res.length-1-i];
//        }
//            return res;
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()) {
            String a = scan.nextLine();
            String b = scan.nextLine();

            // 求出两个字符串中较长的那个字符串长度
            int lenA = a.length();
            int lenB = b.length();
            int lenS = lenA > lenB ? lenA : lenB;

            // arrS保存最终生成的结果
            int[] arrA = new int[lenS];
            int[] arrB = new int[lenS];
            int[] arrS = new int[lenS + 1];

            for (int i = 0; i < lenA; i++) {
                arrA[i] = a.charAt(lenA - 1 - i) - '0';
            }


            for (int i = 0; i < lenB; i++) {
                arrB[i] = b.charAt(lenB - 1 - i) - '0';
            }

            for (int i = 0; i < lenS; i++) {
                int sum = arrS[i] + arrA[i] + arrB[i];
                int flag = sum /10;
                arrS[i]  = sum % 10;
                arrS[i+1] += flag;
            }

            for (int i = arrS[lenS] == 0?1:0; i < lenS + 1; i++) {
                System.out.print(arrS[lenS - i]);
            }

            System.out.println();

        }

        scan.close();
    }
}
