import java.util.Scanner;
public class ReturnNumSum2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字:");
        int n = sc.nextInt();
        int res = returnNumSum2(n);
        System.out.println(res);
    }
    public static int returnNumSum2(int n){
        if(n == 1){
            return 1;
        }
        return n + returnNumSum2(n - 1);
    }
}