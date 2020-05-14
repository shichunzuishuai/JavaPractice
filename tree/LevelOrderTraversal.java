package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 层序遍历
 */
public class LevelOrderTraversal {
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

    public  TreeNode build(){
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(2);
        TreeNode C = new TreeNode(3);
        TreeNode D = new TreeNode(4);
        TreeNode E = new TreeNode(5);
        TreeNode F = new TreeNode(6);
        A.setLeft(B);
        A.setRight(C);
        B.setLeft(D);
        C.setLeft(E);
        E.setRight(F);
        return A;
    }

    //层序遍历
    public static void levelOrder(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if(cur.getLeft() != null){
                queue.offer(cur.getLeft());
            }
            if(cur.getRight() != null){
                queue.offer(cur.getRight());
            }
        }
    }

    public static void main(String[] args) {
        LevelOrderTraversal l = new LevelOrderTraversal();
        TreeNode root = l.build();
        levelOrder(root);
    }

}
