package sort;

import java.util.Arrays;

//希尔排序
public class ShellSort {
    public static void shellSort(int[] arr){
        int gap = arr.length / 2;
        while (gap > 1){
            insertSortGap(arr,gap);
            gap /= 2;
        }
        insertSortGap(arr,1);
    }

    private static void insertSortGap(int[] arr, int gap) {
        //从每组的第一个元素开始
        for(int bound = gap; bound <arr.length; bound++){
            int tmp = arr[bound];
            int cur = bound - gap;
            for(;cur >= 0;cur -= gap){
                if(arr[cur] > tmp){
                    arr[cur +gap] = arr[cur];
                }else {
                    break;
                }
            }
            arr[cur + gap] = tmp;
        }
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
}
