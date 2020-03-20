import java.util.Scanner;
public class PrintNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入数字:");
        int n  = sc.nextInt();
        printNum(n);
    }
    public static void printNum(int n){
        if( n > 9){
            printNum( n / 10);
        }
        System.out.println(n % 10);
    }
}

