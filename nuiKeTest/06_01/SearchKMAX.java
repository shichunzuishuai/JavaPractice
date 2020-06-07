import java.util.Scanner;

/**
 * 寻找第K大:
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 */
public class SearchKMAX {
    public static void quick(int[] arr){
        quickHelper(arr,0,arr.length - 1);
    }

    public static void quickHelper(int[] arr,int left, int right) {
        if(left >= right){
            return;
        }
        int index = partition(arr,left,right);
        quickHelper(arr,left,index - 1);
        quickHelper(arr,index + 1,right);
    }
    public static int partition(int[] arr,int left,int right){
        int i = left;
        int j = right;
        int baseVal = arr[right];
        while (i <j) {
            if (i < j && arr[i] >= baseVal){
                i++;
            }
            if (i < j && arr[j] <= baseVal) {
                j--;
            }
                swap(arr,i,j);
        }
        swap(arr,i,right);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static int searchK(int[] arr, int n,int k){
        if(k < 1 || k >n){
            throw new RuntimeException();
        }
        quick(arr);
        int ret = 0;

        return arr[k - 1];
    }
    public static void main(String[] args) {
        int[] arr = {9,5,3,6,8,7};
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int res = searchK(arr,n,k);
        System.out.println(res);
    }
}

