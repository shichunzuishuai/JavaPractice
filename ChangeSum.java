public class ChangeSum {
    /**
     * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
     * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。
     * 若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
     * 示例:
     * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
     * 输出: [1, 3]
     * @param args
     */
    public static void main(String[] args) {

    }
    public static int[] change(int[] arr1,int[] arr2){
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;
        int j = 0;
        int ave = 0;
        while (i < arr1.length){
            sum1 += arr1[i];
            i++;
        }
        while (j < arr2.length){
            sum2 += arr2[i];
            j++;
        }
        ave = (sum1 + sum2) / 2;
        return arr1;
    }


}
