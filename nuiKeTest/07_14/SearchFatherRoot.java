/**
 * 链接：https://www.nowcoder.com/questionTerminal/70e00e490b454006976c1fdf47f155d9
 * 来源：牛客网
 *
 * 有一棵无穷大的满二叉树，其结点按根结点一层一层地从左往右依次编号，根结点编号为1。现在有两个结点a，b。请设计一个算法，求出a和b点的最近公共祖先的编号。
 *
 * 给定两个int a,b。为给定结点的编号。请返回a和b的最近公共祖先的编号。注意这里结点本身也可认为是其祖先。
 *
 * 测试样例：
 * 2，3
 * 返回：1
 *
 * 这是一道很经典的考察二叉树的问题，题目本身不难，很常规的考察公共祖先问题，使用递归可以很简单的解决。
 * 但是请做完的同学再想想有没有别的解法？
 *
 * 【解题思路】：
 * 满二叉树的子节点与父节点之间的关系为root = child / 2
 * 注意这里为什么不是(child-1)/2 因为题目中根节点编号有
 * 意设置为1了
 * 利用这个关系，如果a ！= b，就让其中的较大数除以2，
 * 如此循环知道a == b， 即是原来两个数的最近公共祖先
 */
public class SearchFatherRoot {
    public static void main(String[] args) {

    }

    public int getLCA(int a, int b) {
        // write code here
        if(a == b){
            return a;
        }
        return a > b ? getLCA(a / 2, b) : getLCA(a, b / 2);
    }
}
