package tree;

import java.util.LinkedList;
import java.util.Queue;

//判段是否为完全二叉树
//完全二叉树: 相当于右下角缺了一块
//分为两个状态,层序遍历如果遇到只有左子树或者没有子树情况就进入第二状态
//进入第二状态继续便利,只要发现子树就不是完全二叉树
class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
}
public class IsComplete {
    public static void main(String[] args) {

    }
    public static boolean isComplete(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //标志位,看是否进入第二阶段
        boolean flag = false;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //这是第一阶段
            if(!flag){
                if(cur.left != null &&cur.right != null){
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }else if(cur.left == null && cur.right != null){
                    return false;
                }else if(cur.left != null && cur.right == null){//进入第二阶段
                   flag = true;
                   queue.offer(cur.left);
                }else {
                    flag = true;
                }
            }else {//第二阶段
                if(cur.left == null || cur.right == null){
                    return false;
                }
            }
        }
        return true;
    }
}
