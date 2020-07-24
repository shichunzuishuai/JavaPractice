/**
 * 链接:
 * https://www.nowcoder.com/practice/6fadc1dac83a443c9434f350a5803b51?tpId=49&&tqId=29316&rp=1&r
 * u=/activity/oj&qru=/ta/2016test/question-ranking
 *
 *有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
 * 给定一个二位数组arr及题目中的参数n，请返回结果数组。
 * 测试样例：
 * [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
 * 返回：[4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
 *
 * 思路:
 * 我们只需要先确定右上角的坐标startX = 0,startY = n-1.
 * 最左小角的数据坐标为(3,0)。当这个数字打
 * 印完后，横坐标+1，超出了行数。那么打印结束。规律如上图所说：
 * 横坐标+1，纵坐标+1。
 *
 */

import java.util.Arrays;

public class PrintTwoArr {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] res = arrayPrint(arr,4);
        System.out.println(Arrays.toString(res));
    }
    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
       int[] res = new int[n * n];
       int a = 0;
       for(int i = n - 1; i > -1; i--){
           for(int j = 0; j < n - i; j++){
               res[a] = arr[j][i + j];
               res[n * n - 1 - a] = arr[n - 1 - j][n - 1 - i - j];
               a++;
           }
       }
        return res;
    }
}
