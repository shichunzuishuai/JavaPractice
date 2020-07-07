import java.util.Scanner;

public class DifferentSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int res = addAB(A, B);
            System.out.println(res);
        }
    }
    public static int addAB(int A, int B){
        if(B != 0){
            int a = A ^ B;
            int b = (A & B) << 1;
            return addAB(a,b);
        }else {
            return A;
        }
    }
}
