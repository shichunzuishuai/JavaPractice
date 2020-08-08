/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * //OJ链接：https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?
 * tpId=13&tqId=11191&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * //1. 可以使用递归方式
 * //2. 可以层序遍历，统计层数，也就是深度or高度
 */

import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public int treeDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while (!q.isEmpty()){
            depth++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
        }
        return depth;
    }
    public int treeDepth2(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(treeDepth2(root.left),treeDepth2(root.right));
    }
}
