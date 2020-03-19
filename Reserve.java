import java.util.Arrays;
public class Reserve {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reserve(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void reserve(int[] arr){
        int left = 0;
        int right = arr.length - 1;
        for( left = 0; left < right; left++){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
        }
    }
}
