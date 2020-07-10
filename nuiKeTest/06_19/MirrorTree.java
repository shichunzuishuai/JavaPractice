import MidNode.MidNode;

public class MirrorTree {
    static class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
     this.val = val;

     }

     }

    public void Mirror(TreeNode root) {
        TreeNode cur = null;
        if(root != null) {
            cur = root.left;
            root.left = root.right;
            root.right = cur;
            if (root.left != null) {
                Mirror(root.left);
            }
            if (root.right != null) {
                Mirror(root.right);
            }
        }
    }
}
