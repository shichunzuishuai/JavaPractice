import java.util.Arrays;

/**
 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同， 则称这种编码为格雷码(Gray Code)，
 * 请编写一个函数，使用递归的方法生成N位的格雷码。
 * 给定一个整数n，请返回n位的格雷码，顺序为从0开始。
 * 测试样例：
 * 1
 * 返回：["0","1"]
 */
public class GrayCode {
    public static void main(String[] args) {
        int n = 2;
        String[] arr = getGray(n);
        System.out.println(Arrays.toString(arr));

    }

    public static String[] getGray(int n){
        String[] str1 = null;
        if(n == 1){
            return str1 = new String[]{"0","1"};
        }
        String[] str2 = getGray( n - 1);
        str1 = new String[2 * str2.length];
        for(int i = 0; i <str2.length; i ++){
            str1[i] = "0" + str2[i];
            str1[str1.length - 1 - i] = "1" + str2[i];
        }

        return str1;
    }
}
