import java.util.Scanner;
public class MyToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(myToString(arr));
    }
    public static String myToString(int[] arr){
        String flag1 = "[";
        for (int i = 0; i < arr.length; i++) {
            flag1 += arr[i];
            if(i < arr.length - 1) {
                flag1 += ",";
            }else {
                flag1 += "]";
            }
        }
        return flag1;
    }
}
