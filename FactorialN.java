import java.util.Scanner;
public class FactorialN {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("请输入一个数字:");
        int n = sc.nextInt();
        int res = factorial(n);
        System.out.println(res);
    }
    public static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
