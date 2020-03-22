import java.util.Scanner;
public class OverLode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(maxNum(n,m));
        System.out.println("请输入两个小数:");
        double k = sc.nextDouble();
        double p = sc.nextDouble();
        System.out.println(maxNum(k,p));
        System.out.println(maxNum(k,p,n));
    }
    public static int maxNum(int n, int m){
        int max = n > m ? n : m;
        return max;
    }
    public static double maxNum(double n,double m){
        double max = n > m ? n : m;
        return max;
    }
    public static double maxNum(double n ,double m, int k){
        double res = maxNum(n,m);
        double max = res > k ? res : k;
        return max;
    }
}
