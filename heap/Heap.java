package heap;

import java.util.Arrays;

public class Heap {
    //堆是一个完全二叉树,通常用数组来表示
    //数组中的有效元素为[0,size);
    //index表示从那个下标进行调整
    private static void shiftDown(int[] arr, int size, int index){
        int parent = index;
        //根据父节点找子节点的下标
        int child = (index * 2) + 1;
        while (child < size){
            if(child + 1 < size && arr[child] < arr[child + 1]){
                child = child + 1;
            }
            //child经过上面操作已经指向左右子树中较大的值
            if(arr[child] > arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }else {
                break;
            }
            parent = child;
            child = (parent * 2) + 1;
        }
    }
    //建堆  从后往前遍历,从最后一个非叶子节点出发.一次进行向下调整
    public static void createHeap(int[] arr, int size){
        for(int i = (size - 1 - 1) / 2; i >= 0; i --){
            shiftDown(arr,size,i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,9,3,6,7,4,5};
        createHeap(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }


}
