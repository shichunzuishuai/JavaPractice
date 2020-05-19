package map;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
 * 输入: [1,2,1,3,2,5]
 * 输出: [3,5]
 */
public class SingleNumber2 {
    public int[] singleNumber(int[] nums) {
        //1.先针对所有元素进行异或操作
        int ret = 0;
        for (int x: nums) {
            ret ^= x;
        }
        //2.在ret中找一个部位0的bit位
        int bit = 0;
        for(;bit < 32; bit++){
            if((ret & (1 << bit)) > 0){
                break;
            }
        }
        //此时bit 位对应的值就为1
        int a = 0;
        int b = 0;
        for (int x:nums) {
            if((x & (1 << bit)) > 0){
                a ^= x;
            }else {
                b ^= x;
            }
        }
        return new int[]{a,b};
    }
}
