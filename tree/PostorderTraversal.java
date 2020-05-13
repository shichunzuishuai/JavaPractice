package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历
 */
public class PostorderTraversal {
    static class TreeNode{
        private char val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(char val){
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
    PreOrder pre = new PreOrder();
    //构建树
    public TreeNode build1(){

        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        A.setLeft(B);
        A.setRight(C);
        B.setLeft(D);
        B.setRight(E);
        E.setLeft(G);
        C.setRight(F);
        return A;
    }

    //1.直接使用递归后序遍历树
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

    //2.使用集合递归遍历树
    public List<Character> postOrder2(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.addAll(postOrder2(root.left));
        list.addAll(postOrder2(root.right));
        list.add(root.val);
        return list;
    }


    public static void main(String[] args) {
        PostorderTraversal p = new PostorderTraversal();
        TreeNode root = p.build1();
//        p.postOrder(root);
        System.out.println(p.postOrder2(root));
    }

}
