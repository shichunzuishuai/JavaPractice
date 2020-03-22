import java.util.Arrays;
import java.util.Scanner;
public class PrintArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("数组为:" + Arrays.toString(arr));
        System.out.println("打印的数为:");
        printArray(arr);
    }
    public static void printArray(int[] arr){
        for (int i:arr
             ) {
            System.out.println(i);
        }
    }
}
