/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 * OJ链接：https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?
 * tpId=13&tqId=11196&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * 解题思路：
 * 思路一：保存第一个，剩下的整体前移一个，第一个放在最后，完成一次移动，一次能移动，多次也可以
 * 思路二：局部逆置，在整体逆置
 */
public class LeftRotateString {
    public static void main(String[] args) {
        String str = "abcdefg";
        int n = 2;
        leftRotateString(str,2);
    }
    //思路一:
    public static String leftRotateString(String str,int n) {
        if(str.length() == 0 || n == 0){
            return str;
        }
        n %= str.length();
        char[] arr = str.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = c;
        }
        //此方法可以把一个数组转成字符串
        String res = new String(arr);
        System.out.println(res);
        return res;
    }

    //方法二
    public static String leftRotateString2(String str,int n) {
        if(str.length() == 0 || n == 0){
            return str;
        }
        n %= str.length();
        char[] arr = str.toCharArray();
        reserveStr(arr,0,n - 1);
        reserveStr(arr,n,str.length() - 1);
        reserveStr(arr,0,str.length() - 1);
        return new String(arr);
    }

    private static void reserveStr(char[] arr, int begin, int end) {
//        char[] arr = str.toCharArray();
        while (begin < end){
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            begin++;
            end--;
        }
    }

}
