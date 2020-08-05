import java.util.ArrayList;

/**
 * 回溯的特点:
 * 一般都有一个结果集合待选结果
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点
 * 开始往下一直到叶结点所经过的结点形成一条路径。
 * 解析：
 * //OJ链接：https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?
 * tpId=13&tqId=11177&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //这是一个典型的DFS回溯的算法
 * //回溯法本质是一个基于DFS的穷举的过程
 * //1. 先添加值 //2. 在判定现有结果是否满足条件 //3. DFS //4. 回退
 *
 */
public class TreePathSum {

     public class TreeNode {
         int val = 0;
         TreeNode left = null;
         TreeNode right = null;

         public TreeNode(int val) {
         this.val = val;

         }

     }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        FindPathDFS(root,target,result,list);
        return result;
    }

    private void FindPathDFS(TreeNode root, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if(root == null){
            return;
        }
        //不为空把当前节点的值放进list中
        list.add(root.val);
        //放进之后把当前节点的值从target 中减去
        target -= root.val;
        //进行判断,看是否符合条件
        // 1. 已经是叶子节点了
        // 2. 从root到该叶子节点，之和是target
        // 3. 是叶子节点，但是不满足节点，也不影响，程序会直接退出
        if(root.left == null && root.right == null && target == 0){
            //注意深浅拷贝
            result.add(new ArrayList<Integer>(list));
        }
        FindPathDFS(root.left,target,result,list);
        FindPathDFS(root.right,target,result,list);
        list.remove(list.size() - 1);
     }
}
