import java.util.Scanner;
public class ArraySearchDichotomy {
    public static void main(String[] args) {
        int[] arr = new int[6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(binarySearch(arr,6));
    }
    public static int binarySearch(int[] arr ,int toFind) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind > arr[mid]) {
                left = mid + 1;
            } else if (toFind < arr[mid]) {
                right = mid - 1;
            } else if(toFind == arr[mid]){
                return mid;
            }
        }
        return -1;
    }
}
