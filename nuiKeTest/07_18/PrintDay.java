/**
 * 根据输入的日期，计算是这一年的第几天。。
 * 详细描述：
 * 输入某年某月某日，判断这一天是这一年的第几天？。
 * 输入三行，分别是年，月，日
 * 输出描述:
 * 成功:返回outDay输出计算后的第几天;
 *                                            失败:返回-1
 * 示例1
 * 输入
 *
 * 复制
 * 2012
 * 12
 * 31
 * 输出
 *
 * 复制
 * 366
 */

import java.util.Scanner;

public class PrintDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int res = cac(a,b,c);
            System.out.println(res);
        }
    }
    public static int cac(int a,int b,int c){
        int res = 0;
        int[] arr1 = {31,28,31,30,31,30,31,31,30,31,30,31};
 //       int[] arr2 = {31,29,31,30,31,30,31,31,30,31,30,31};
        boolean flag = false;
        if(a % 400 == 0 || a % 4 == 0 && a % 100 != 0){
            flag = true;
        }
        for (int i = 1; i < b; i++) {
            res += arr1[i - 1];
        }
        if(flag == true && b >= 2){
            res += (c + 1);
        }else {
            res += c ;
        }
        return res;
    }
}
