/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * //OJ链接：https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?
 * tpId=13&tqId=11194&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 * //解题思路：
 * 注意，代码中只给你你目标和，其实隐含条件就是序列最大值不会大于该值
 * 可以采用滑动窗口的思想进行解决，这种方式可以说很nb了
 */

import java.util.ArrayList;

public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int low = 1;
        int high = 2;
        while (low < high){
            int total = (low + high) * (high - low + 1) / 2;
            if(total > sum){
                low++;
            }else if(total < sum){
                high++;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++){
                    list.add(i);
                }
                result.add(list);
                //当添加完这一租后,应从low 向后继续找,看是否还有符合要求的
                low++;
            }
        }
        return result;
    }
}
