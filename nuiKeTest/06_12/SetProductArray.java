import java.util.Arrays;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
 * 来源：牛客网
 *
 * [编程题]构建乘积数组
 * 热度指数：217630时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
 * 算法知识视频讲解
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 *
 * 思路:下三角用连乘可以很容求得，上三角，从下向上也是连乘。
 * 因此我们的思路就很清晰了，先算下三角中的连乘，即我们先算出B[i]中的一部分，
 * 然后倒过来按上三角中的分布规律，把另一部分也乘进去。
 */
public class SetProductArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] tmp = multiply(arr);
        System.out.println(Arrays.toString(tmp));
    }
    public static int[] multiply(int[] A){
        int[] B = new int[A.length];
        if(A.length != 0){
            B[0] = 1;
//            for(int i = 1; i < A.length;i++){
//                B[i] = B[i - 1] * A[i - 1];
//            }
            int i = 1;
            while (i < A.length){
                B[i] = B[i - 1] * A[i - 1];
                i++;
            }
            int tmp = 1;
            int j = A.length - 2;
            while (j >= 0){
                tmp *= A[j + 1];
                B[j] *= tmp;
                j--;
            }

//            for(int j = A.length - 2; j >= 0; j--){
//               tmp *= A[j + 1];
//               B[j] *= tmp;
//            }
        }
        return B;
    }
}
