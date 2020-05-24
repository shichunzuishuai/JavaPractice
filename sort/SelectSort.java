package sort;

import java.util.Arrays;
//选择排序
public class SelectSort {
    public static void selectSort(int[] arr){
        for(int bound = 0; bound < arr.length; bound++){
            //此时借助bound将区间分成两部分了
            //[0,bound)为已排序区间,[bound,size)为待排序区间
            //然后就是在待排序区间中找到最小值放到bound的位置上
           for(int cur = bound; cur < arr.length; cur++){
               if(arr[cur] < arr[bound]){
                   swap(arr,cur,bound);
               }
           }
        }

    }

    private static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
