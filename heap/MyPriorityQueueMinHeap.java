package heap;

public class MyPriorityQueueMinHeap {
    private int[] arr = new int[100];
    private int size;
    public void offer(int x){
        arr[size] = x;
        size++;
        shiftUp(arr,size,size - 1);
    }

    private void shiftUp(int[] arr, int size, int index) {
        int child = index;
        int parent = (child - 1) / 2;
        while (child > 0){
            if(arr[child] < arr[parent]){
                int tmp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = tmp;
            }else {
                break;
            }
            child = parent;
            parent = (child - 1) / 2;
        }
    }
    public Integer poll(){
        if(size <= 0){
            return null;
        }
        int ret = arr[0];
        arr[0] = arr[size - 1];
        size--;
        shiftDown(arr,size,0);
        return ret;
    }

    private void shiftDown(int[] arr,int size,int index) {
        int parent = index;
        int child = (parent * 2) + 1;
        while (child < size){
            if(child + 1 < size && arr[child + 1] < arr[child]){
                child = child + 1;
            }
            if(arr[child] < arr[parent]){
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
    private Integer peek(){
        if(size == 0){
            return null;
        }
        return arr[0];
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueueMinHeap queue = new MyPriorityQueueMinHeap();
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(7);
        queue.offer(3);
        queue.offer(6);
        queue.offer(8);
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur);
        }
    }

}
