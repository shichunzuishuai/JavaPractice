/**
 * 链接：https://www.nowcoder.com/questionTerminal/f5805cc389394cf69d89b29c0430ff27
 * 来源：牛客网
 *
 * 给定一个长度为N(N>1)的整型数组A，可以将A划分成左右两个部分，左部分A[0..K]，右部分A[K+1..N-1]，K可以取值的范围是[0,N-2]。求这么多划分方案中，左部分中的最大值减去右部分最大值的绝对值，最大是多少？
 *
 * 给定整数数组A和数组的大小n，请返回题目所求的答案。
 *
 * 测试样例：
 * [2,7,3,1,1],5
 * 返回：6
 */
public class MaxGap {
    public static void main(String[] args) {
        int[] arr = {2,7,3,1,1};
        int n = 5;
        int res = findMaxGap(arr,n);
        System.out.println(res);

    }
    public static int findMaxGap(int[] A, int n) {
        // write code here
        int result = 0;
        int maxA = 0;
        int maxB = 0;
        for(int i = 0; i < n; i++){
            int r = i;
            if(r <= n - 2){
                for(int j = 0; j <= r; j++){
                    maxA = A[j] > maxA ? A[j] : maxA;
                }
                for(int k = i + 1; k < A.length;k++){
                    maxB = A[k] > maxB ? A[k] : maxB;
                }
                result = Math.abs(maxA - maxB) > result ? Math.abs(maxA - maxB) : result;
                maxA = 0;
                maxB = 0;
            }else {
                break;
            }

        }
        return result;
    }
}
