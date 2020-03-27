import java.util.Scanner;
public class IsOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        isOrder(arr);
    }
    public static void isOrder(int[] arr) {
        int flag = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println("此数组不是升序的");
                break;
            } else {
                flag++;
            }
            if (flag == arr.length - 1) {
                System.out.println("此数组是升序的");
            }
        }
    }
}

