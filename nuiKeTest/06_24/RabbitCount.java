/**
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，
 * 问每个月的兔子总数为多少？
 * 输入int型表示month
 *
 *
 * 输出描述:
 *
 * 输出兔子总数int型
 * 示例1
 * 输入
 *
 * 9
 * 输出
 *
 * 34
 */

import java.util.Scanner;

public class RabbitCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int res = count(n);
            System.out.println(res);
        }
    }
    public static int count(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return count(n - 1) + count(n - 2);
    }
}
