package BiShi;

import java.util.Scanner;

public class FeiBo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long ret = feiBo(n);
        System.out.println(ret);
    }
      public static long feiBo(int n){
            long left = 1;
            long right = 1;
            long ret = 0;
            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 1;
            }
            for(int i = 3; i <= n; i++){
                ret = left + right;
                left = right;
                right = ret;
            }
            return ret;
      }
}
