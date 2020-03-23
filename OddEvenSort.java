import java.util.Arrays;
public class OddEvenSort {
    public static void main(String[] args) {
        int[] arr = {15,68,94,162,31,46,87,165,89,20};
        int[] ret = change(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] change(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        for(int i = left; i < right; i++) {
            for (int j = right; j > i; j--) {
                if (arr[i] % 2 != 0 || arr[j] % 2 == 0) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else if (arr[i] % 2 == 0) {
                    left++;
                } else if (arr[right] % 2 != 0) {
                    right--;
                }
            }
        }

        return arr;
    }
}
