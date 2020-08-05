/**
 * 输入一个非空整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输
 * 入的数组的任意两个数字都互不相同。
 * 解析：
 * //OJ链接：https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?
 * tpId=13&tqId=11176&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路： //看清楚，是二叉搜索树 后序遍历 //二叉搜索树:它或者是一棵空树，或者是具有下列性质的二叉树：
 * 若它的左子树不空，则左子树上所有结点的值均小于它的 根结点的值； 若它的右子树不空，
 * 则右子树上所有结点的值均大于它的根结点的值；
 * //后序遍历：先左后右再根 //BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （
 * 也就是root节点），如果去掉最后一个元素的序列为 T，那么T满足：T可以分成两段，前一段（左子树）小于x，
 * 后一段（右子树）大于x，且这两段（子树）都是合法的后序序列 //验证思路就是：当前序列，及其子序列必须都满足上述定
 */
public class BinarySearchTree {
    public boolean VerifySquenceOfBST(int [] sequence) {
        //sequence == null可能情况是[],所以必须有sequence.length == 0
        if(sequence == null || sequence.length == 0){
            return false;
        }
        return VerifySquenceOfBSTHelp(sequence,0,sequence.length - 1);
    }

    private boolean VerifySquenceOfBSTHelp(int[] sequence, int start, int end) {
        //结束条件,如果只有一个子节点或者为空,则结束
        if(start >= end){
            return true;
        }
        int x = sequence[end];
        int i = 0;
        //这是分成两个部分,前面的都应该小于x,后面的都应该大于x
        while (i < end && sequence[i] < x){
            i++;
        }
        for(int j = i; j < end; j++){
            if(sequence[j] < x){
                return false;
            }
        }
        return VerifySquenceOfBSTHelp(sequence,start,i - 1) && VerifySquenceOfBSTHelp(sequence,i ,end);
    }

}
