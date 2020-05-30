package heap;

//优先级队列
public class MyPriorityQueue {
    private int[] arr = new int[100];//先不考虑扩容
    private int size = 0;//有效的元素区间
    public void offer(int x){
        arr[size] = x;
        size++;
        shiftUp(arr, size,size - 1);
    }
    //向上调整
    private void shiftUp(int[] arr, int size, int index) {
        int child = index;
        int parent = (index - 1) / 2;
        //当child为0的时候没证明已经到根节点了,不用继续进行了
        while (child > 0){
            if(arr[child] > arr[parent]){
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

    //如何删除队首元素?
    //1.把最后一个元素的值填入到0号元素上
    //2.从0下标进行向下调整
    public Integer poll(){
        if(size == 0){
            return null;
        }
        int ret = arr[0];
        arr[0] = arr[size - 1];
        size--;
        shiftDown(arr,size,0);
        return ret;
    }
//向下调整
    private void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = (index * 2) + 1;
        while (child < size){
            if(child + 1 <size && arr[child] < arr[child + 1]){
                child = child + 1;
            }
            if(arr[parent] < arr[child]){
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

    public Integer peek(){
        if(size == 0){
            return null;
        }
        return arr[0];
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        queue.offer(9);
        queue.offer(6);
        queue.offer(5);
        queue.offer(8);
        queue.offer(3);
        queue.offer(1);
        queue.offer(2);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            System.out.print(cur + " ");
        }

    }

}
