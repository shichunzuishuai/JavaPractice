import java.util.Scanner;

public class AppleCount {
    public static int appleCount(int n){
        int res = 0;
        if(n % 2 != 0){
            return -1;
        }
        if(n % 8 == 0){
            res = n / 8;
            return res;
        }
        int mul = n / 8;
        res = mul;
        n = n % 8;
        while (mul >= 0){
            if(n % 6 == 0){
                res += n / 6;
                return res;
            }else {
                n = n +8;
                mul--;
                res--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int res = appleCount(n);
            System.out.println(res);
        }
    }
}
