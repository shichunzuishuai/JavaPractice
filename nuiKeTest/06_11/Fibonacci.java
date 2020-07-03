import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/18ecd0ecf5ef4fe9ba3f17f8d00d2d66
 * 来源：牛客网
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...在Fibonacci数列中的数我们称为Fibonacci数。
 * 给你一个N，你想让其变为一个Fibonacci数，每一步你可以把当前数字X变为X-1或者X+1，
 * 现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 * 输出描述:
 * 输出一个最小的步数变为Fibonacci数"
 * 示例1
 * 输入
 * 15
 * 输出
 * 2
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[100];
            arr[0] = 1;
            arr[1] = 1;
            for(int i = 2; i < 100; i++){
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] > n){
                    System.out.println((arr[i] - n < n - arr[i - 1]) ? arr[i] - n : n - arr[i - 1]);
                    break;
                }
            }

        }
    }
//    public static int fibonacci(int n){
//        if(n == 1){
//            return 1;
//        }
//        if(n == 2){
//            return 1;
//        }
//        return fibonacci(n -1) + fibonacci(n - 2);
//    }
}
