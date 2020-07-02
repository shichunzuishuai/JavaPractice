import java.util.Scanner;

/**
 * 输入一个正整数n,求n!(即阶乘)末尾有多少个0？ 比如: n = 10; n! = 3628800,所以答案为2
 * 输入描述:
 *
 * 输入为一行，n(1 ≤ n ≤ 1000)
 * 输出描述:
 * 输出一个整数,即题目所求
 * 示例1
 * 输入
 * 10
 * 输出
 *
 * 2
 */
public class NFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //int res = nFactorial(n);
            int res = 0;
            for (int i = 5; i <= n; i *= 5){
                res += n / i;
            }
            System.out.println(res);
        }
    }
}

//    public static int nFactorial(int n) {
//
//        if (n == 1) {
//            return n;
//        }
//        return n * nFactorial(n - 1);
//    }
//    public static int zeroCount(int n){
//        int res = nFactorial(n);
//        String str = String.valueOf(res);
//        int count = 0;
//        for(int i = str.length() - 1; i > -1; i--){
//            if(str.charAt(i) == '0'){
//                count++;
//            }else {
//                break;
//            }
//
//        }
//        return count;
//    }
//}
