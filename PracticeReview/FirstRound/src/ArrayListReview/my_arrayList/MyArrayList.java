package my_arrayList;

import java.util.Arrays;

    public class MyArrayList {
        private int[] arr;
        private int useSize;
        private static final int intCapacity = 10;

        public MyArrayList() {
            this.arr = new int[intCapacity];
            this.useSize = 0;
        }

        public int[] getArr() {
            return arr;
        }

        public void setArr(int[] arr) {
            this.arr = arr;
        }

        public int getUseSize() {
            return useSize;
        }

        public void setUseSize(int useSize) {
            this.useSize = useSize;
        }

        public static int getIntCapacity() {
            return intCapacity;
        }

        // 打印顺序表
        public void display() {
            for(int i = 0; i < useSize; i++){
                System.out.print(arr[i] + " ");
            }
        }
        private boolean isFull(){
            if(useSize == arr.length){
                return true;
            }
            return false;
        }

        // 在 pos 位置新增元素
        public void add(int pos, int data) {
            if(isFull()){
                this.arr = Arrays.copyOf(arr,2 * arr.length);
            }
            if(pos < 0 || pos > useSize){
                System.out.println("插入的位值不合法");
                return;
            }
            for (int i = useSize - 1; i >= pos; i--){
                arr[i + 1] = arr[i];
            }
            arr[pos] = data;
            useSize ++;
        }

        // 判定是否包含某个元素
        public boolean contains(int toFind) {
            for (int i = 0; i < useSize; i++){
                if(toFind == arr[i]){
                    return true;
                }
            }
            return false;
        }
        // 查找某个元素对应的位置
        public int search(int toFind) {
            for (int i = 0; i < useSize; i++){
                if(toFind == arr[i]){
                    return i;
                }
            }
            return -1;
        }
        // 获取 pos 位置的元素
        public int getPos(int pos) {
            if(useSize == 0){
                return -1;
            }
            if(pos < 0 || pos >= useSize){
               throw new RuntimeException("pos的位置不合法");
            }
            return arr[pos];
        }
        // 给 pos 位置的元素设为 value
        public void setPos(int pos, int value) {
            arr[pos] = value;
        }
        //删除第一次出现的关键字key
        public void remove(int toRemove) {
            for(int i = 0; i < useSize; i++){
                if(arr[i] == toRemove){
                    for(int j = i; j < useSize; j++){
                        arr[j] = arr[j + 1];
                    }
                    useSize--;
                    return;
                }
            }
        }
        // 获取顺序表长度
        public int size() {
            return useSize ;
        }
        // 清空顺序表
        public void clear() {
            useSize = 0;
        }


    }
