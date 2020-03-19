import java.util.Arrays;

public class ProductArray {
    /**
     * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
     * 其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
     * 示例:
     * 输入: [1,2,3,4,5]
     * 输出: [120,60,40,30,24]
     * @param args
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
//        int[] ret = product(arr);
        int[] ret = product2(arr);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] product(int[] arr){
        int[] arr2 = new int[arr.length];
        int sum = 1;
        for(int i = 0; i < arr.length; i++){
            sum *= arr[i];
        }
        for(int j = 0; j < arr2.length; j++){
            arr2[j] = sum / arr[j];
        }
        return arr2;
    }
    public static int[] product2(int[] arr){
        int[] arr2 = new int[arr.length];
        int res1 = 1;
        int res2 = 1;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                res1 *= arr[j];
            }
            for(int k = arr.length - 1; k > i; k--){
                res2 *= arr[k];
            }
            arr2[i] = res1 * res2;
            res1 = 1;
            res2 = 1;
        }
        return arr2;
    }
}
