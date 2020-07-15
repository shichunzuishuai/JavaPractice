/**
 *链接：https://www.nowcoder.com/questionTerminal/729d11d043d8448e83befa1410b694fe
 * 来源：牛客网
 * 输入一个字符串，然后对每个字符进行奇校验，最后输出校验后的二进制数(如'3’，输出：10110011)。
 *
 * 输入描述:
 * 输入包括一个字符串，字符串长度不超过100。
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，
 * 对于字符串中的每一个字符，输出按题目进行奇偶校验后的数，每个字符校验的结果占一行。
 * 示例1
 * 输入
 * 3
 * 3a
 * 输出
 * 10110011
 * 10110011
 * 01100001
 */

import java.util.Scanner;
public class CheckNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            check(str);
        }
    }
    public static void check(String str){
        char[] s = str.toCharArray();
        int[] nums = new int[8];
        for (int i = 0; i < s.length; i++) {
            int n = 0x01;
            int j = 7;
            int count = 0;
            while (j > 0){
                nums[j] = (s[i] & n) == 0 ? 0 : 1;
                if(nums[j] == 1) {
                    count++;
                }
                n = n << 1;
                j--;
            }
            if((count & 1) == 0){
                nums[0] = 1;
            }else {
                nums[0] = 0;
            }
            for (int a : nums) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}

