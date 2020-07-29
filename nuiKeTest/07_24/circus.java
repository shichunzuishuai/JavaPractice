/**
 *链接：https://www.nowcoder.com/questionTerminal/c2afcd7353f84690bb73aa6123548770
 * 来源：牛客网
 *
 * 搜狐员工小王最近利用假期在外地旅游，在某个小镇碰到一个马戏团表演，精彩的表演结束后发现团长正和大伙在帐篷前激烈讨论，小王打听了下了解到， 马戏团正打算出一个新节目“最高罗汉塔”，即马戏团员叠罗汉表演。考虑到安全因素，要求叠罗汉过程中，站在某个人肩上的人应该既比自己矮又比自己瘦，或相等。 团长想要本次节目中的罗汉塔叠的最高，由于人数众多，正在头疼如何安排人员的问题。小王觉得这个问题很简单，于是统计了参与最高罗汉塔表演的所有团员的身高体重，并且很快找到叠最高罗汉塔的人员序列。 现在你手上也拿到了这样一份身高体重表，请找出可以叠出的最高罗汉塔的高度，这份表中马戏团员依次编号为1到N。
 *
 * 输入描述:
 *
 * 首先一个正整数N，表示人员个数。
 * 之后N行，每行三个数，分别对应马戏团员编号，体重和身高。
 *
 *
 * 输出描述:
 *
 * 正整数m，表示罗汉塔的高度。
 * 示例1
 * 输入
 *
 * 6<br/>1 65 100<br/>2 75 80<br/>3 80 100<br/>4 60 95<br/>5 82 101<br/>6 81 70<br/>
 * 输出
 *
 * 4
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class circus {
    static class People{
        public int weight;
        public int height;
        public People(int weight,int height){
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int N = scanner.nextInt();
            People[] arr = new People[N];
            for (int i = 0; i < N; ++i) {
                int index = scanner.nextInt();
                arr[index - 1] = new People(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(arr, new Comparator<People>() {
                public int compare(People p1, People p2) {
                    int result = Integer.compare(p1.height, p2.height);
                    if (result != 0)
                        return result;
                    else
                        return Integer.compare(p1.weight, p2.weight);
                }
            });

            int[] dp = new int[N];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; ++i) {
                dp[i] = 1;
                for (int j = i - 1; j >= 0; --j) {
                    if (arr[i].weight > arr[j].weight
                            || (arr[i].weight == arr[j].weight && arr[i].height == arr[j].height)) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                max = Math.max(dp[i], max);
            }
            System.out.println(max);
        }
    }
}
