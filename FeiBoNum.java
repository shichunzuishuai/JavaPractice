import java.util.Scanner;
public class FeiBoNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字:");
        int n = sc.nextInt();
        System.out.println(feiBoNum(n));
    }
    public static int feiBoNum(int n){
        if(n <= 2){
            return 1;
        }
        return feiBoNum(n - 1) + feiBoNum(n - 2);
    }
}
