/**
 * 链接：https://www.nowcoder.com/questionTerminal/58e7779c9f4e413cb80792d33ba6acaf
 * 来源：牛客网
 * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 —— 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，二
 * 十九个纳特(Knut)兑一个西可，很容易。”现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
 * 输入描述:
 * 输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。这里Galleon是[0, 107]]区间内的整数，Sickle是[0,
 * 17)区间内的整数，Knut是[0, 29)区间内的整数。
 * 输出描述:
 * 在一行中用与输入同样的格式输出哈利应该被找的零钱。如果他没带够钱，那么输出的应该是负数。
 * 示例1
 * 输入
 * 10.16.27 14.1.28
 * 输出
 * 3.2.1
 */

import java.util.Scanner;
public class CalculateMoney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            String[] arr = str1.split(" ");
            calculate(arr);
        }
    }
    public static void calculate(String[] arr){
        String[] arr1 = arr[0].split("\\.");
        int[] arr2 = new int[3];
        String[] arr3 = arr[1].split("\\.");

        int[] arr4 = new int[3];
        for (int i = 0; i < 3; i++) {
            arr2[i] = Integer.parseInt(arr1[i]);
            arr4[i] = Integer.parseInt(arr3[i]);
        }

        if(arr2[0] > arr4[0] || (arr2[0] == arr4[0] && arr2[1] > arr4[1]) ||
                (arr2[0] == arr4[0] && arr2[1] == arr4[1])){
           if (arr4[2] > arr2[2]){
               arr2[2] += 29;
               arr2[1] -= 1;
           }
           if(arr4[1] > arr2[1]){
               arr2[1] += 17;
               arr2[0] -= 1;
           }
            int i = arr2[0] - arr4[0];
            int j = arr2[1] - arr4[1];
            int k = arr2[2] - arr4[2];
            System.out.println( "-" + i + "." + j + "." + k);

            return;
        } else if(arr4[2] < arr2[2]){
            arr4[2] += 29;
            arr4[1] -= 1;
        }
        if(arr4[1] < arr2[1]){
            arr4[1] += 17;
            arr4[0] -= 1;
        }
        int i = arr4[0] - arr2[0];
        int j = arr4[1] - arr2[1];
        int k = arr4[2] - arr2[2];
        System.out.println(i + "." + j + "." + k);
    }
}
