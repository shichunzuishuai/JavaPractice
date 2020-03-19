import java.util.Scanner;
public class RecursionFeibo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字:");
        int n = sc.nextInt();
        int res = recursionFeibo(n);
        System.out.println(res);
    }
    public static int recursionFeibo(int n){
        if(n <= 2){
            return 1;
        }
        return recursionFeibo(n-1) + recursionFeibo(n-2);
    }
}
