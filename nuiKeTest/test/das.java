import java.util.Arrays;

public class das {
    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j = arr.length - 1; j > i; j--){
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
        return arr;
    }
}
