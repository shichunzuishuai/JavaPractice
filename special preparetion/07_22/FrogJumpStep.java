import java.util.Scanner;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算
 * 不同的结果）
 *
 * 思路:
 * dp动态规划的核心:
 *     1. 定义方程
 *     2.编写状态转移方程
 *     3.设置初始值
 *
 * fn(n) : 青蛙跳上第n级台阶的总跳法数   [定意状态]
 * fn(n) = f(n - 1) + f( n - 2)      [转移方程]
 * f(0) = 1; f(1) = 1; f(2) = 2;     [设置初始值]
 *
 *
 */
public class FrogJumpStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n= scanner.nextInt();
            int res = step(n);
            System.out.println(res);
        }
    }

    public static int step(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
