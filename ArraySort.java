import java.util.Arrays;
public class ArraySort {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,56,58,47,862,84};
        int[] arr2 = arraySort(arr);
        System.out.println(Arrays.toString(arr2));
    }
    public static int[] arraySort(int[] arr){
        int n = arr.length;
        int[] arr2 = new int[n];
        int[] arr3 = new int[n];
        int[] arr4 = new int[n];
        int count = 0;
        int flag = 0;
       // int f = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 != 0){
                arr2[count] = arr[i];
                count++;
            }else {
                arr3[flag] = arr[i];
                flag++;
            }
        }
        System.arraycopy(arr3,0,arr2,count,flag );
//        int a = 0;
//        for(int k = 0; k < n; k++){
//            if( k < count){
//                arr4[f] = arr2[k];
//            }else {
//                arr4[f] = arr3[a];
//                a++;
//            }
//            f++;
//        }
        return arr2;
    }
}