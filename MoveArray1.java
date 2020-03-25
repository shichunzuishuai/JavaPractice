import java.util.Arrays;

public class MoveArray1 {
    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param args
     */
    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6,7};
       // int[] arr2 = moveArray1(arr,2);
        int[] arr2 = moveArray2(arr,2);
        System.out.println(Arrays.toString(arr2));
    }
    public static int[] moveArray1(int[] arr,int k){
        int len = arr.length;
        int temp = 0;
        int omk = k % len;
        for(int i = 0; i < omk; i++){
            temp = arr[len - 1];
            for(int j = len - 2; j >= 0; j--){
                arr[j+1] = arr[j];
            }
            arr[0] = temp;
        }
        return arr;
    }
    public static int[] moveArray2(int[] arr,int k){
        int[] arr2 = new int[arr.length];
        int omk = k % arr.length;
        for(int i = 0; i < arr.length; i++){
            int omk2 = (i + omk) % arr.length;
            arr2[omk2] = arr[i];
        }
        return arr2;
    }

}
