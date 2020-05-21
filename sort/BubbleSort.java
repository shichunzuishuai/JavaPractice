package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j  = array.length - 1; j > i; j --){
                if(array[j - 1] > array[j]){
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }
    public static void bubbleSort2(int[] array){
        boolean flag = false;
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0;j < array.length - i - 1; j++){
                flag = false;
                if(array[j] > array[j + 1]){
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
            if(flag = false){
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 5, 2, 7, 3, 6, 8};
        bubbleSort2(array);
        System.out.println(Arrays.toString(array));
    }

}
