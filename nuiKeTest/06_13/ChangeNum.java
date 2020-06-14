import java.util.Arrays;
import java.util.Stack;

/**
 *请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
 * 给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 */
public class ChangeNum {
    public static void main(String[] args) {
        int[] arr = {1,2};
        exchangeAB(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] exchangeAB(int[] AB){
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2; i++) {
            stack.add(AB[i]);
        }
        for (int i = 0; i < 2; i++) {
            AB[i] = stack.pop();
        }
        return AB;
    }
}
