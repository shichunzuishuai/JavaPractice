import java.util.Scanner;
public class PrintMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要打的数字:");
        int n = scanner.nextInt();
        print(n);
    }
    public static void print(int n){
        for(int i = 1; i <= n ; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(i + "*" + j + " = " + i * j + "  ");
            }
            System.out.println();
        }
    }
}
