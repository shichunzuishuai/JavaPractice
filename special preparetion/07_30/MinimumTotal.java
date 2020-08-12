/**
 * 给出一个三角形，计算从三角形顶部到底部的最小路径和，每一步都可以移动到下面一行相邻的数字，
 * 例如，给出的三角形如下：
 * [↵     [2],↵    [3,4],↵   [6,5,7],↵  [4,1,8,3]↵]
 * 最小的从顶部到底部的路径和是2 + 3 + 5 + 1 = 11。
 * 注意：
 * 如果你能只用O（N）的额外的空间来完成这项工作的话，就可以得到附加分，其中N是三角形中的行总数。
 *
 * 方法：动态规划
 * 状态：
 *   子状态：从(0,0)到(1,0),(1,1),(2,0),...(n,n)的最短路径和
 *   F(i,j): 从(0,0)到(i,j)的最短路径和
 * 状态递推：
 *   F(i,j) = min( F(i-1, j-1), F(i-1, j)) + triangle[i][j]
 * 初始值：
 *   F(0,0) = triangle[0][0]
 * 返回结果：
 *   min(F(n-1, i))
 */

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle.isEmpty()){
            return 0;
        }
        List<List<Integer>> minPath = new ArrayList<>();
        //给每一行添加一个List
        for(int i = 0; i < triangle.size(); i++){
            minPath.add(new ArrayList<>());
        }
        //F[0][0]初始化
        minPath.get(0).add(triangle.get(0).get(0));
        for(int i = 1; i < triangle.size(); i++){
            int curSum = 0;
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    curSum = minPath.get(i - 1).get(0);
                }else if(j == i){
                    curSum = minPath.get(i - 1).get(j - 1);
                }else {
                    curSum = Math.min(minPath.get(i - 1).get(j - 1),minPath.get(i - 1).get(j));
                }
                minPath.get(i).add(triangle.get(i).get(j) + curSum);
            }
        }
        int size = triangle.size();
        // min(F(n-1, i))
        int allMin = minPath.get(size - 1).get(0);
        for(int i = 1; i < size; ++i)
         {
            allMin = Math.min(allMin,minPath.get(size - 1).get(i));
        }
        return allMin;
    }
}
