import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个由非负整数填充的m x n的二维数组，现在要从二维数组的左上角走到右下角，
 * 请找出路径上的所有数字之和最小的路径。
 * 注意：你每次只能向下或向右移动。
 *
 * 方法：动态规划
 * 状态：
 *   子状态：从(0,0)到达(1,0),(1,1),(2,1),...(m-1,n-1)的最短路径
 *   F(i,j): 从(0,0)到达F(i,j)的最短路径
 * 状态递推：
 *   F(i,j) = min{F(i-1,j) , F(i,j-1)} + (i,j)
 * 初始化：
 *   F(0,0) = (0,0)
 *   特殊情况：第0行和第0列
 *   F(0,i) = F(0,i-1) + (0,i)
 *   F(i,0) = F(i-1,0) + (i,0)
 * 返回结果：
 *   F(m-1,n-1)
 */
public class MinPathSum {
    public int minPathSum (int[][] grid) {
        Map<Integer,Integer> map = new HashMap<>();
        // write code here
        int row = grid.length;
        int low = grid[0].length;
        //第一行的所有行
        for (int i = 1; i < row; i++) {
            grid[i][0] = grid[i  -1][0] + grid[i][0];
        }
        //第一列的所有和
        for (int i = 1; i < low; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < low; j++) {
                grid[i][j] = Math.min(grid[i - 1][j],grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[row - 1][low - 1];
    }
}
