//import java.util.Scanner;
//
//public class GetSequeOddNum {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            int n = scanner.nextInt();
//            getNum(n);
//        }
//    }
//    public static void getNum(int n){
//        int a1 = n * n - n + 1;
//        int ret = a1;
//        if(n == 1){
//            System.out.println("1");
//        }
//        for(int i = 0; i < n; i++){
//            if(i == n-1){
//                System.out.println(ret);
//            }else {
//                System.out.print(ret + "+" );
//                ret += 2;
//            }
//        }
//    }
//}
import java.util.Scanner;

public class GetSequeOddNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = GetSequeOddNum1(n);
        System.out.print(str);
    }
    public static String GetSequeOddNum1(int n) {
        int m = n * (n - 1) + 1;
        int ret = 0;
        int ans = m;
        String answer = "";
        for (int i =0;i < n;i++) {
            ret += m;
            m+=2;
        }
        if (Math.pow(n,3)==ret) {
            for (int j = 0;j < n-1;j++){
                answer = answer + ans + "+";
                ans+=2;
            }
            return answer + ans;
        }
        return null;
    }
}