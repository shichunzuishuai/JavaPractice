import java.util.Scanner;
public class PrintBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字:");
        int n = sc.nextInt();
        printBinary1(n);
    }
    public  static void printBinary1(int n) {
        System.out.println("偶数序列:");
        for (int i = 31; i > 0; i -= 2){
            System.out.println((n >> i) & 1);
        }
        System.out.println("奇数序列:");
        for(int j = 30; j >= 0; j -= 2){
            System.out.println((n >> j) & 1);
        }
    }
}
