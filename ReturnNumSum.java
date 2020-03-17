import java.util.Scanner;
public class ReturnNumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入正整数:");
        int n = sc.nextInt();
        int res = returnNumSum(n);
        System.out.println(res);
    }
    public static int returnNumSum(int n){
        if(n < 9){
            return n;
        }
        return n % 10 + returnNumSum(n / 10);
    }
}
