import java.util.Scanner;
public class MinCommonMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int res = common(a,b);
            System.out.println(res);
        }
    }
    public static int common(int a, int b){
        int t  = 0;
        if(a < b){
            t = a;
            a = b;
            b = t;
        }
        int x = a;
        int y = b;
        while (b != 0){
            t = a % b;
            a = b;
            b = t;
        }
        return x * y / a;
    }
}
