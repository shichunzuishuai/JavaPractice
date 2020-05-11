package tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTest2 {
    static class TreeNode {
        private char val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(Character val) {
            this.val = val;
        }

        public char getVal() {
            return val;
        }

        public void setVal(char val) {
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

    public  TreeNode build() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.setLeft(B);
        A.setRight(C);
        B.setRight(D);
//        B.setRight(E);
//        E.setLeft(G);
//        C.setRight(F);
        return A;
    }

    /**
     * 判断是不是完全二叉树
     *
     * 先针对这个数进行层序遍历
     * 判定过程分为两个阶段
     * 第一阶段:要求访问到的节点必须有左右两个子树,如果子树为空或只有左子树,则调到第二阶段
     *          如果只有右子树则直接返回false
     * 第二阶段:要求访问到的节点必须没有子树,如果右子树则一定不是完全二叉树
     * 如果遍历结束也没有找到不符合要求的节点,则这个数就是完全二叉树
     */
    public boolean isComplete(TreeNode root){
        if(root == null){
            return true;
        }
        boolean isFirstStep = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(isFirstStep){
                if(cur.getLeft() != null && cur.getRight() != null){
                    queue.offer(cur.getLeft());
                    queue.offer(cur.getRight());
                }else if(cur.getLeft() != null && cur.getRight() == null){
                    isFirstStep = false;
                }else if(cur.getRight() != null && cur.getLeft() == null){
                    return false;
                }else {
                    isFirstStep = false;
                }
            }else {
                if(cur.getLeft() != null || cur.getRight() != null){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TreeTest2 t = new TreeTest2();
        TreeNode root = t.build();
        System.out.println(t.isComplete(root));
    }

}
