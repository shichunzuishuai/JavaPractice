import java.util.Arrays;
public class ChangeArray {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {9,8,7,6,5};
        System.out.println("交换前:arr1 = " + Arrays.toString(arr1)
                + ",arr2 = " + Arrays.toString(arr2));
        change(arr1,arr2);
        System.out.println("交换后:arr1 = " + Arrays.toString(arr1)
                + ",arr2 = " + Arrays.toString(arr2));
    }
    public static void change(int[] arr1,int[] arr2){
            int tmp = 0;
        for(int i = 0; i < arr1.length; i++){
            tmp = arr1[i];
            arr1[i] = arr2[i];
            arr2[i] = tmp;
        }
    }
}
