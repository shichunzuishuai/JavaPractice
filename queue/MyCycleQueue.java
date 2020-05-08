package queue;

public class MyCycleQueue {
    int k;
    int size = 0;
    int head = 0;
    int last = 0;
    int[] arr = new int[k];
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCycleQueue(int k) {
        this.k = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size == arr.length){
            return false;
        }
        arr[last] = value;
        last++;
        if(last >= arr.length){
            last = 0;
        }
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        int cur = arr[head];
        head++;
        size--;
        if(head >= arr.length){
            head = 0;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        int cur = arr[head];
        return cur;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        if(last != 0){
            return arr[last - 1];
        }
        return arr[arr.length - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(size == arr.length){
            return true;
        }
        return false;
    }
}
