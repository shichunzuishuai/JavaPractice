package tree;

import java.util.Arrays;

public class HeapReview {
    public static void main(String[] args) {
        HeapReview heapReview = new HeapReview();
        int[] arr = {9,5,2,7,3,6,8};
        int[] ret = heapReview.build(arr);
        System.out.println(Arrays.toString(ret));
    }
    //向下调整 小堆
    public void shiftDown(int[] arr, int size, int index){
        int parent = index;
        int child = index * 2 + 1;
        while (child < size){
                if(child + 1 < size && arr[child + 1] < arr[child]){
                child = child + 1;
            }
                if(arr[child] < arr[parent]){
                    swap(arr,child,parent);
                }else {
                    break;
                }
                //更新child和parent的值
                parent = child;
                child = parent * 2 + 1;
        }
    }
    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //向下调整 大堆
    public void shiftDown2(int[] arr, int size,int index){
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size){
            if(child + 1 < size && arr[child + 1] > arr[child]){
                child = child +1;
            }
            if(arr[child] > arr[parent]){
                int temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
            }else {
                break;
            }
            parent = child;
            child = parent * 2 + 1;
        }
    }

    //构建一个堆
    public int[] build(int[] arr){
        for(int i = (arr.length - 1 - 1)/2; i >= 0; i--){
            shiftDown2(arr,arr.length,i);
        }
        return arr;
    }
}
