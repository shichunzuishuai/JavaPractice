package tree;

import doubleHeadList.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

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

     public  TreeNode build(){
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
    //直接先序打印树
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.getVal());
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
    //先序遍历树,用集合的方式打印出来
    public static List<Character> preOrder1(TreeNode root){
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        list.add(root.getVal());
        list.addAll(preOrder1(root.getLeft()));
        list.addAll(preOrder1(root.getRight()));
        return list;
    }
    //不使用递归的方法先序打印
    public static List<Character> preOrder2(TreeNode root){
        //1.创建一个集合用来存放最后遍历出来的结果
        List<Character> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        //2.创建一个栈先把根放进去当栈不为空,把栈顶的元素弹出
        //然后加入到list集合中,然后判断右树是不是空,不是空加入栈
        //然后判断左树是不是空,不是空加入栈,依次进行
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.getVal());
            if(node.getRight() != null){
                stack.push(node.getRight());
            }
            if(node.getLeft() != null){
                stack.push(node.getLeft());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        PreOrder p = new PreOrder();
        TreeNode root = p.build();
        //测试直接打印
        //preOrder(root);
        //测试用集合打印
        //System.out.println(preOrder1(root));
        //不用递归方法打印
        List<Character> list = preOrder2(root);
        System.out.println(list);

    }
    //求数的节点个数
    public static int size(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + size(root.left) + size(root.right);
    }
    //求数的叶子结点个数
    public static int leftSize(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return leftSize(root.left) + leftSize(root.right);
    }
    //求第k层的节点个数
    public static int kLevelSize(TreeNode root,int k){
        if(root == null || k < 1){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return kLevelSize(root.left, k -1) + kLevelSize(root.right, k -1);
    }

}
