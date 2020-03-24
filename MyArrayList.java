public class MyArrayList {
    public int[] elem;//null
    public int usedSize;//0

    //设置默认容量
    public static final int DEFAULT_SIZE = 10;

    public MyArrayList() {
        this.elem = new int[DEFAULT_SIZE];
        this.usedSize = 0;
    }
    public boolean isFull() {
        if(this.usedSize == this.elem.length) {
            return true;
        }
        return false;
    }
    public void add(int pos,int data){
        if(isFull()){
            System.out.println("顺序表是满的");
            return;
        }else {
            for(int i = usedSize - 1; i >= pos; i--){
                elem[i + 1] = elem[i];
            }
            elem[pos] = data;
            usedSize++;
        }
    }
    //判断是否包含某个数字
    public boolean contains(int toFind){
        if(isEmpt()){
            System.out.println("顺序表示空的");
        }else{
            for(int i = 0; i < this.usedSize;i++){
                if(this.elem[i] == toFind){
                    return true;
                }
            }
        }
        return false;
    }
    //判断是不是空的
    public boolean isEmpt(){
        if(this.usedSize == 0){
            return true;
        }
        return false;
    }
    //查找元素,返回下标
    public int seach(int toFind){
        if(isEmpt()){
            System.out.println("顺序表示空的");
        }else{
            for(int i = 0; i < this.usedSize; i++){
                if(toFind == this.elem[i]){
                    return i;
                }
            }
        }
        return -1;
    }
    //获取pos的位置
    public int getPos(int pos){
        if(isEmpt()){
            System.out.println("顺序表示空的");
        }
        if(pos < 0 || pos > this.usedSize ){
            return -1;
        }
        return this.elem[pos];
    }
    public void remove(int key){
        if(isEmpt()){
            System.out.println("顺序表示空的");
        }
        int index = seach(key);
        if(index == -1){
            return;
        }
        for(int i = key; i < this.usedSize - 1; i++){
            if(key == this.elem[i]){
                this.elem[i] = this.elem[i + 1];
            }
            this.usedSize--;
        }
    }
}