import java.util.Scanner;
public class FactorialSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字:");
        int n = sc.nextInt();
        System.out.println(factorialSum(n));
    }
    public static int factorialSum(int n ){
        int sum = 0;
        for(int i = 1;i <= n; i++){
          //  sum += factorial(i);
            sum += jc(i);
        }
        return sum;
    }
//    public static int factorial(int n){
//        int res = 1;
//        for(int i = 1; i <= n; i++){
//            res *= i;
//        }
//        return res;
//    }
    public static int jc(int n){
        if(n == 1){
            return 1;
        }
        return n * jc(n - 1);
    }
}
