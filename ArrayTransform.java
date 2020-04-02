import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;
public class ArrayTransform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("原先的数组为:" + Arrays.toString(arr));
        int[] arr2 = transform(arr);
        System.out.println("替换之后的数组为:" + Arrays.toString(arr2));
    }
    public static int[] transform(int[] arr){
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i] * 2;
        }
        return arr2;
    }
}
