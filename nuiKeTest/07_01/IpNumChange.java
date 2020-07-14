/**
 * 链接：https://www.nowcoder.com/questionTerminal/66ca0e28f90c42a196afd78cc9c496ea
 * 来源：牛客网
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验
 * 输入描述:
 *
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * 示例1
 * 输入
 *
 * 10.0.3.193
 * 167969729
 * 输出
 *
 * 167773121
 * 10.3.3.193
 */

import java.util.Scanner;
public class IpNumChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            String n = scanner.next();
            System.out.println(ipToInt(str));
            System.out.println(intToIp(n));
        }
        scanner.close();
    }

    private static String intToIp(String str) {
        String result = "";
        Long input = Long.parseLong(str);
        for (int i = 3; i >= 0; i--) {
            result = (input & 0x000000FF) + "." + result;
            input >>>= 8;
        }
        return result.substring(0, result.length() - 1);
    }

    private static long ipToInt(String str) {
        String[] array;
        long result = 0;
        array = str.split("[.]");
        for (String s : array) {
            result = (result << 8) + Integer.parseInt(s);
        }
        return result;
    }

}
