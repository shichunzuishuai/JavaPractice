package arraytest;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * 示例 1:
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 */

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,4};
        int ret = pivotIndex(nums);
        System.out.println(ret);
    }
    public static int pivotIndex(int[] nums){
        int sum = 0;
        int ave = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        for(int j = 0; j <nums.length; j++){
            if(ave * 2 + nums[j] == sum){
                return j;
            }
            ave += nums[j];
        }
        return -1;
    }
}
