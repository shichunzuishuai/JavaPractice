package tree;

import java.util.Stack;

public class TreeTest1 {
    static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }


    public TreeNode build(){
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);

        A.left = B;
        A.right = C;
        B.right = D;
        C.left = E;
        return A;
    }

    //给定两个二叉树，编写一个函数来检验它们是否相同。
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    //示例 1:
    //输入:       1         1
    //          / \       / \
    //         2   3     2   3
    //
    //        [1,2,3],   [1,2,3]
    //
    //输出: true
    //思路:1.先判断p,q是不是空树,在判断p,q是否有一个空树
    //     2.看P,q的根节点的值是不是相等,递归看根节点的左子树是不是相等
    //     3.递归看根节点右子树是不是相等
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        return (p.val == q.val) && (isSameTree(p.left,q.left))
                && (isSameTree(p.right,q.right));
    }

    //572. 另一个树的子树
    //给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
    // s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树
    //示例 1:
    //给定的树 s:
    //
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //给定的树 t：
    //
    //   4
    //  / \
    // 1   2
    //返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null){
            return false;
        }
        //判段s中是否包含这个树=>先看s和t是否相同 ||s.left包含t||s.right包含t
        return isSameTree(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }


    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回它的最大深度 3 。
     */
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);

    }

    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 本题中，一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过
     * 示例 1:
     * 给定二叉树 [3,9,20,null,null,15,7]
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回 true 。
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return (left - right <= 1 && left - right >= -1)&& isBalanced(root.left)
                && isBalanced(root.right);
    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的。
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     */

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
       return isSymmetric2(root.getLeft(),root.getRight());
    }
    public boolean isSymmetric2(TreeNode t1,TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return (t1.getVal() == t2.getVal() && isSymmetric2(t1.getLeft(),t2.getRight())
                && isSymmetric2(t1.getRight(),t2.getLeft()));
    }



    public static void main(String[] args) {
        TreeTest1 t = new TreeTest1();
        //判断两个数是否相等
        TreeNode p = t.build();
//        TreeNode q = t.build();
//        System.out.println(t.isSameTree(p, q));
        preOrder(p);
    }

    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
             TreeNode ret = stack.pop();
            System.out.println(ret.val);
            if(ret.right != null){
                stack.push(ret.right);
            }
            if(ret.left != null){
                stack.push(ret.left);
            }
        }
    }

}
