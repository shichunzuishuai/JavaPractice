import java.util.Scanner;
public class Candies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.nextLine();
            String[] arr = a.split(" ");
            int num[] = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                num[i] = Integer.parseInt(arr[i]);
            }
            count(num);
        }
    }

    public static  void count(int [] arr){
//        if(arr[0] - arr[2] + arr[1] + arr[3] != 0){
//            System.out.println("NO");
//        }else {
//            int a = arr[2] - (arr[1] + arr[3]) / 2;
//            int b = (arr[1] + arr[3]) / 2;
//            int c = (arr[3] - arr[1]) / 2;
//            System.out.println(a + " " + b + " " + c);
//
//        }
         int a = (arr[0] + arr[2]) /2;
         int b = a - arr[0];
         int c = b - arr[1];
         if( b + c == arr[3]){
             System.out.println(a + " " + b + " " + c);
         }else {
             System.out.println("NO");
         }
    }
}
