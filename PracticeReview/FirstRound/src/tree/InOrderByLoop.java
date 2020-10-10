package tree;

import java.util.Stack;
//非递归实现中序遍历
public class InOrderByLoop {
    public void  inOrderByLoop(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true){
            //循环往左找,把路径上遇到的节点都入栈
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            //如果炸为空,结束
            if(stack.isEmpty()){
                break;
            }
            //取栈顶元素
            TreeNode top = stack.pop();
            System.out.println(top);
            cur = top.right;
        }
    }
}
