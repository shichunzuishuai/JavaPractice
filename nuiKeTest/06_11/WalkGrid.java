import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e8bb8e68434e42acbcdff0341f2a32c5
 * 来源：牛客网
 * 有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，
 * 计算机器人有多少种走法。
 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
 * 测试样例：
 * 2,2
 * 返回：2
 */
public class WalkGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int res = count(x,y);
            System.out.println(res);
        }
    }
    //动态规划求解
    public static int count(int x,int y){
        int[][] arr = new int[x][y];
        arr[0][0] = 1;
//        for(int i = 1; i < x; i++){
//            arr[i][0] = arr[i - 1][0];
//        }
        int i = 1;
        int j = 1;

        while (i < x){
            arr[i][0] = arr[i - 1][0];
            i++;
        }
        while (j < y){
            arr[0][j] = arr[0][j - 1];
            j++;
        }

        for( i = 1; i < x; i++){
            for( j = 1; j < y; j++){
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[x - 1][y - 1];
    }
}
