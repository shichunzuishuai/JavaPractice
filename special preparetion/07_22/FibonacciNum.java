import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FibonacciNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int res = fib(n);
            System.out.println(res);
        }
    }
    //相当于使用了动态规划的思想
     public static int fib(int n){
        if(n == 0){
            return 0;
        }
        int first = 1;
        int second = 1;
        int third = 1;
        while (n > 2){
            third = first + second;
            first = second;
            second = third;
            n--;
        }
        return third;
     }
     //递归使用剪枝的思想,就是用一张MAP保存要求的数的前一个和前前一个
     public static int fib2(int n){
        Map<Integer,Integer> filter = new HashMap<>();
         if(n == 0 || n == 1){
             return n;
         }
         if(n == 2){
             return 1;
         }
         int pre = 0;
         if(filter.containsKey(n - 1)){
             pre = filter.get(n - 1);
         }else {
             pre = fib(n - 1);
             filter.put(n - 1,pre);
         }
         int ppre = 0;
         if(filter.containsKey(n - 2)){
             ppre = filter.get(n -2);
         }else {
             ppre = fib(n - 2);
             filter.put(n - 2, ppre);
         }
         return ppre + pre;
     }
}
