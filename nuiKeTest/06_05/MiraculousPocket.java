/**
 * 编程题]神奇的口袋
 * 有一个神奇的口袋，总的容积是40，用这个口袋可以变出一些物品，这些物品的总体积必须是40。John现在有n个想要得到的物品，每个物品的体积分别是a1，a2……an。John可以从这些物品中选择一些，如果选出的物体的总体积是40，那么利用这个神奇的口袋，John就可以得到这些物品。现在的问题是，John有多少种不同的选择物品的方式。
 *
 * 输入描述:
 *
 * 输入的第一行是正整数n (1 <= n <= 20)，表示不同的物品的数目。接下来的n行，每行有一个1到40之间的正整数，分别给出a1，a2……an的值。
 * 输入
 * 3
 * 20
 * 20
 * 20
 * 输出
 * 3
 */

import java.util.Scanner;
public class MiraculousPocket {
    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
             n = scanner.nextInt();
             arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = scanner.nextInt();
            }
            int res = func(0,40);
            System.out.println(res);
        }
    }
    public static int func(int i,int sum){
        if(i == n){
            return 0;
        }
        if(arr[i] == sum){
            return 1 + func(i + 1,sum);
        }else if(sum > arr[i]){
            return func(i +1,sum - arr[i]) + func(i +1,sum);
        }
        return func(i + 1,sum);

    }
}
