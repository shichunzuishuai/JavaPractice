import java.util.Scanner;
public class MaxNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入三个数字:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int res = max3(n,m,k);
        System.out.println(res);
    }
    public static int  max2(int n,int m){
        int max = n > m ? n : m;
        return max;
    }
    public static int max3(int n, int m, int k){
        int res = max2(n,m);
        int max = res > k ? res : k;
        return max;
    }
}
