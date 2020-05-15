package tree;

import java.util.Scanner;

/**
 * 编一个程序，读入用户输入的一串先序遍历字符串，根据此字符串建立一个二叉树（以指针方式存储）。 例如如下的先序遍历字符串： ABC##DE#G##F### 其中“#”表示的是空格，空格字符代表空树。建立起此二叉树以后，再对二叉树进行中序遍历，输出遍历结果。
 * 输入描述:
 * 输入包括1行字符串，长度不超过100。
 * 输出描述:
 * 可能有多组测试数据，对于每组数据，
 * 输出将输入字符串建立二叉树后中序遍历的序列，每个字符后面都有一个空格。
 * 每个输出结果占一行。
 * 示例1
 * 输入
 * 复制
 * abc##de#g##f###
 * 输出
 * 复制
 * c b e g d f a
 */
public class CreateTreePreOrder {
    static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(char val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String line = scanner.next();
            index = 0;
            TreeNode root = buildTree(line);
            inOrder(root);
            System.out.println();
        }
    }

    private static void inOrder(TreeNode root) {
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static int index = 0;

    //入口
    private static TreeNode buildTree(String line) {
        index = 0;
        return createTreePreOrder(line);
    }
    //辅助递归的方法
    private static TreeNode createTreePreOrder(String line) {
        char ch = line.charAt(index);
        if(ch == '#'){
            return null;
        }
        TreeNode node = new TreeNode(ch);
        index++;
        node.left = createTreePreOrder(line);
        index++;
        node.right = createTreePreOrder(line);
        return node;
    }

}
