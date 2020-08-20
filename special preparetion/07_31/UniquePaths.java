/**
 * 一个机器人在m×n大小的地图的左上角（起点，下图中的标记“start"的位置）。
 * 机器人每次向下或向右移动。机器人要到达地图的右下角。（终点，下图中的标记“Finish"的位置）。
 * 可以有多少种不同的路径从起点走到终点？
 *
 * 方法：动态规划
 * 状态：
 *   子状态：从(0,0)到达(1,0),(1,1),(2,1),...(m-1,n-1)的路径数
 *   F(i,j): 从(0,0)到达F(i,j)的路径数
 * 状态递推：
 *   F(i,j) = F(i-1,j) + F(i,j-1)
 * 初始化：
 *   特殊情况：第0行和第0列
 *   F(0,i) = 1
 *   F(i,0) = 1
 * 返回结果：
 *   F(m-1,n-1)
 */
public class UniquePaths {
    public int uniquePaths (int m, int n) {
        // write code here
        int[][] arr = new int[m][n];
        //只竖着走,只有一种方法
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        //只横着走,也只有一种方法
        for (int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++){
                //F[i][j] = F[i - 1][j] + F[i][j - 1]
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }
}
