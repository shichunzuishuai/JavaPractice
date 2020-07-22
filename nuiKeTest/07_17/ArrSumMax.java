/**
 * 链接：https://www.nowcoder.com/questionTerminal/5a304c109a544aef9b583dce23f5f5db
 * 来源：牛客网
 *
 * 一个数组有 N 个元素，求连续子数组的最大和。 例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为 3
 *
 * 输入描述:
 *
 * 输入为两行。 第一行一个整数n(1 <= n <= 100000)，表示一共有n个元素 第二行为n个数，即每个元素,每个整数都在32位int范围内。以空格分隔。
 *
 *
 * 输出描述:
 *
 * 所有连续子数组中和最大的值。
 * 示例1
 * 输入
 *
 * 3 -1 2 1
 * 输出
 *
 * 3
 */

import java.util.*;

public class ArrSumMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            max(arr);
        }
    }
    public static void max(int[] arr){
        List<Integer> list = new ArrayList<>();
        //记录前k个元素中的子数组最大和
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //如果和小于0了,那么就不要了,和等于这个数
            if(sum < 0){
                sum  = arr[i];
            }else {
                sum += arr[i];
            }
            if(max < sum){
                max = sum;
            }
        }
        System.out.println(max);
    }
}
