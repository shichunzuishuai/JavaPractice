/**
 * 链接：https://www.nowcoder.com/questionTerminal/e016ad9b7f0b45048c58a9f27ba618bf
 * 来源：牛客网
 *
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 *
 * 测试样例：
 * [1,3,5,2,2],5,3
 * 返回：2
 */

public class FindKth {
    public int findKth(int[] a, int n, int K) {
        // write code here
        findKthHelp(a,0,a.length - 1);
//        System.out.println(Arrays.toString(a));
        return a[K - 1];

    }
    public void findKthHelp(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int index = partation(a,left,right);
        findKthHelp(a, left, index - 1);
        findKthHelp(a, index + 1, right);
    }
    public int partation(int[] a,int left, int right){
        int i = left;
        int j = right;
        int baseVal = a[right];
        while(i < j){
            while(i < j && a[i] >= baseVal){
                i++;
            }
            while(i < j && a[j] <= baseVal){
                j--;
            }
            swap(a,i,j);
        }
        swap(a,i,right);
        return i;
    }
    public  void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}