/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * 解析：
 * //OJ链接：https://www.nowcoder.com/practice/7fe2212963db4790b57431d9ed259701?
 * tpId=13&tqId=11175&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路： //本质是层序遍历二叉树，借助queue即可
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelTree {
     public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }
            return list;
    }



}
