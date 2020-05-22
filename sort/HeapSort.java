package sort;

import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr){
        //1.先建立堆
        createHeap(arr);
        int heapSize = arr.length;
        for(int i = 0; i < arr.length; i++){
            //交换堆顶和最后一个元素
            swap(arr,0,heapSize - 1);
            heapSize--;
            //针对当前堆从根节点向下调整
            shiftDown(arr,heapSize,0);
        }
    }

    private static void createHeap(int[] arr) {
        //从最后一个非叶子节点开始,向前遍历,依次进行向下调整
        for(int i = (arr.length -1 - 1) / 2;i >= 0; i--){
            shiftDown(arr,arr.length,i);
        }
    }
    //向下调整

    private static void shiftDown(int[] arr, int size, int index) {
         int parent = index;
         int child = index * 2 + 1;
         while (child < size){
             if(child + 1 < size && arr[child + 1] > arr[child]){
                 child = child + 1;
             }
             if(arr[child] > arr[parent]){
                 swap(arr,child,parent);
             }
             parent = child;
             child = parent * 2 + 1;
         }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,5,2,7,3,6,8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
