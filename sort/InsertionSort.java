package sort;

import java.util.Arrays;

public class InsertionSort {
    public static void insertSort(int[] array) {
        // 有序区间: [0, bound)
        // 无序区间: [bound, size)
      for(int bound = 1; bound < array.length; bound++){
          int tmp = array[bound];
          int cur = bound - 1;
          for(;cur >= 0; cur--){
              if(array[cur] > tmp){
                  array[cur + 1] = array[cur];
              }else {
                  break;
              }
          }
          array[cur + 1] = tmp;
      }
    }
    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        //shellSort(array);
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

}
