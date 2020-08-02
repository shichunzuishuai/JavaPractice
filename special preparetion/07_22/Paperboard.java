import java.util.Scanner;

/**
 *  我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。请问用n个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩
 * 形，总共有多少种方法？
 * 比如n=3时， 2*3 的矩形块有3种覆盖方法：
 * //OJ链接：https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?
 * tpId=13&tqId=11163&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-
 * ranking //解析：
 * 用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，每次放置的时候，无非两种放法，
 * 横着放或竖着放 //其中，横着放一个之后，下一个的放法也就确定了，故虽然放置了两个矩形，但属于同一种放法
 * 其中，竖着放一个之后，本轮放置也就完成了，也属于一种方法
 * 所以，当2*n的大矩形被放满的时候，它无非就是从上面两种放置方法放置来的。
 * 我们继续使用dp来进行处理，当然后续会发现，斐波那契数列的方式也可以处理，因为之前已经讲过，
 * 就留给大家完成 //状态定义：f(n) : 用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形所用的总方法数
 * 状态递推：f(n) = f(n-1)【最后一个竖着放】 + f(n-2)【最后两个横着放】
 * 初始化：f(1) = 1,f(2) = 2,f(0)=1,注意f(0)我们这个可以不考虑，如果考虑值设为1，
 *
 */
public class Paperboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
        }
    }
    public static int rectCover(int n){
        if(n < 2){
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
