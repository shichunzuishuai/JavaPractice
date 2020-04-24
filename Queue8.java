package Queue;
public class Queue8 {
    int max = 8;
    int[] arr = new int[max];
    static int count = 0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.cheak(0);
        System.out.printf("一共有%d中解法",count);
    }

    /**
     * n代表当前是第几个皇后[n从0开始算,0即表示第一个皇后,也表示第一行]
     * 即第一行是第一个皇后(n=0),第二行表示第二个皇后(n=1)...如果遍历到第九行
     * 说明8个皇后全部放置完毕,得到一种解法
     * 然后回溯,降低一个皇后放到第一行的第二列
     *
     */

    private void cheak(int n){
        if(n == max){
            print();
            return;
        }
        for(int i = 0; i < max; i++){
            arr[n] = i;
            if(judge(n)){
                cheak(n + 1);
            }
        }
    }
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if(arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])){
                return false;
            }
        }
        return true;
    }
    private void print(){
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
