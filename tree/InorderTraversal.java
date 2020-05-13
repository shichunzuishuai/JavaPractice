package tree;

import doubleHeadList.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历树
 */
public class InorderTraversal {
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

    public static TreeNode build() {
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

    //使用递归直接中序打印
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft());
        System.out.println(root.getVal());
        inorder(root.getRight());
    }
    //使用递归用List集合打印
    public static List<Character> inorder1(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.addAll(inorder1(root.getLeft()));
        list.add(root.getVal());
        list.addAll(inorder1(root.getRight()));
        return list;
    }
    //不适用递归,借助栈来打印
    public static List<Character> inorder2(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.getLeft();
            }else {
                cur = stack.pop();
                list.add(cur.getVal());
                cur = cur.getRight();
            }
        }
        return list;
    }




    public static void main(String[] args) {
        TreeNode root = build();
        inorder(root);
//        List<Character> ret = inorder1(root);
//        System.out.println(ret);
//        List<Character> ret = inorder2(root);
//        System.out.println(ret);
    }
}
