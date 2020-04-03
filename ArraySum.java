import java.util.Arrays;
import java.util.Scanner;
public class ArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("数组为:" + Arrays.toString(arr));
        int res = arraySum(arr);
        System.out.println("数组所有元素和为:" + res);
    }
    public static int arraySum(int[] arr){
        int sum = 0;
        for (int i:arr
             ) {
            sum += i;
        }
        return sum;
    }
}
