package map;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        //1.统计每个数字出现的次数
        //key表示具体的某个数,val表示该数出现的次数
        Map<Integer,Integer> map = new HashMap();
        for (int x: nums) {
            Integer count = map.get(x);
            if(count == null){
                map.put(x,1);
            }else {
                map.put(x,count + 1);
            }
        }
        //遍历map,找到只出现一次的数
        for (Map.Entry<Integer,Integer> entry: map.entrySet() ) {
            if(entry.getValue().equals(1)){
                return entry.getKey();
            }
        }
        return 0;
    }
    public int singleNumber2 (int[] nums){
        int ret = 0;
        for (int x:nums) {
            ret ^= x;
        }
        return ret;
    }
}
