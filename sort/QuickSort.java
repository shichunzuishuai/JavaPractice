package sort;

import java.util.Arrays;

public class QuickSort {
   public static void quickSort(int[] arr){
       quickSortHelper(arr,0,arr.length - 1);
   }

    private static void quickSortHelper(int[] arr, int left, int right) {
       if(left >= right){
           return;
       }
       int index = partition(arr,left,right);
       quickSortHelper(arr,left,index - 1);
       quickSortHelper(arr,index + 1,right);
    }

    private static int partition(int[] arr, int left, int right) {
       int baseVal = arr[right];
       int i = left;
       int j = right;
       while (i < j){
           while (i < j && arr[i] <= baseVal){
               i++;
           }
           while (i < j && arr[j] >= baseVal){
               j--;
           }
           swap(arr,i,j);
       }
       swap(arr,i,right);
       return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
