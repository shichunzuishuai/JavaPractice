import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 * 求最后一个被删掉的数的原始下标位置。
 * 以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
 * 如此循环直到最后一个数被删除。
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 * 示例1
 * 输入
 * 8
 * 输出
 * 6
 */
public class ArrayDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
            }
            int res = delete(arr);
            System.out.println(res);
        }
    }
//    public static boolean delete(int[] arr){
//        int flag = arr.length;
//        int[] num = arr.clone();
//        int a = 2;
//        while (flag != 0){
//            for(int i = 0;i < flag - 2; i += 2){
//                if(i == 0){
//                    num[0] = num[0];
//                    num[1] = num[1];
//                }else {
//                    num[a] = arr[i + 1];
//                }
//            }
//            System.out.println(Arrays.toString(num));
//            flag = num.length;
//            a = 2;
//        }
//        if(num.length == 0){
//            return true;
//        }
//        return false;
//    }
        public static int delete(int[] arr){
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int i = 0;
        while (list.size() > 1){
            i = (i + 2) % list.size();
            list.remove(i);
        }
        return list.get(0);
    }
}
