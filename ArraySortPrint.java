import java.util.Arrays;
public class ArraySortPrint {
    /**
     * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
     *
     * 序号代表了一个元素有多大。序号编号的规则如下：
     *
     * 序号从 1 开始编号。
     * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
     * 每个数字的序号都应该尽可能地小。
     */
    public static void main(String[] args) {
        int[] arr = {40,20,10,30};
        int[] arr2 = arr.clone();
        int[] arr4 = search(arr,arr2);
        System.out.println(Arrays.toString(arr4));

    }
    public static int[] search(int[] arr,int[] arr4){
        int[] arr2 = new int[arr.length];
        int[] arr3 = sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = Arrays.binarySearch(arr3,arr4[i]) + 1;
       }
        return arr2;
    }
    public static int[] sort(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
}
